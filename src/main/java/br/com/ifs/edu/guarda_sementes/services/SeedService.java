package br.com.ifs.edu.guarda_sementes.services;

import br.com.ifs.edu.guarda_sementes.dtos.Seeds.CreateSeedDTO;
import br.com.ifs.edu.guarda_sementes.dtos.Seeds.ResponseSeedDTO;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordAlreadyExistsException;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordNotFoundException;
import br.com.ifs.edu.guarda_sementes.models.SeedModel;
import br.com.ifs.edu.guarda_sementes.repositories.ISeedRepository;
import br.com.ifs.edu.guarda_sementes.repositories.IStockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeedService {

    private final ISeedRepository seedRepository;
    private final IStockRepository stockRepository;

    public SeedService(ISeedRepository seedRepository, IStockRepository stockRepository) {
        this.seedRepository = seedRepository;
        this.stockRepository = stockRepository;
    }

    public List<ResponseSeedDTO> list() {
        return this.seedRepository.findAll().stream().map(ResponseSeedDTO::new).collect(Collectors.toList());
    }

    public ResponseSeedDTO create(CreateSeedDTO createSeedDTO) {

        var oldSeed = this.seedRepository.findByName(createSeedDTO.getName());
        if (oldSeed != null) {
            throw new RecordAlreadyExistsException("Seed already exists");
        }

        var oldStock = this.stockRepository.findById(createSeedDTO.getStockId())
                .orElseThrow(() -> new RecordNotFoundException("Stock not found"));

        SeedModel seed = new SeedModel(createSeedDTO.getName(), createSeedDTO.getAmount(), createSeedDTO.getDescription(), oldStock);

        return new ResponseSeedDTO(this.seedRepository.save(seed));
    }
}
