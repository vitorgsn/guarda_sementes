package br.com.ifs.edu.guarda_sementes.services;

import br.com.ifs.edu.guarda_sementes.dtos.stocks.CreateStockDTO;
import br.com.ifs.edu.guarda_sementes.dtos.stocks.ResponseStockDTO;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordAlreadyExistsException;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordNotFoundException;
import br.com.ifs.edu.guarda_sementes.models.StockModel;
import br.com.ifs.edu.guarda_sementes.repositories.IStockRepository;
import br.com.ifs.edu.guarda_sementes.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {

    private final IStockRepository stockRepository;
    private final IUserRepository userRepository;

    public StockService(IStockRepository stockRepository, IUserRepository userRepository) {
        this.stockRepository = stockRepository;
        this.userRepository = userRepository;
    }

    public List<ResponseStockDTO> list() {
        return this.stockRepository.findAll().stream().map(ResponseStockDTO::new).collect(Collectors.toList());
    }

    public ResponseStockDTO create(CreateStockDTO createStockDTO) {

        var oldStock = this.stockRepository.findByName(createStockDTO.getName());

        var oldUser = this.userRepository.findById(createStockDTO.getUserId())
                .orElseThrow(() -> new RecordNotFoundException("User not found."));

        if (oldStock != null) {
            throw new RecordAlreadyExistsException("Stock already exists.");
        }

        StockModel stock = new StockModel(createStockDTO.getName(), oldUser);

        return new ResponseStockDTO(this.stockRepository.save(stock));
    }
}
