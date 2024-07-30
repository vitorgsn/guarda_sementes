package br.com.ifs.edu.guarda_sementes.services;

import br.com.ifs.edu.guarda_sementes.dtos.stock_categories.CreateStockCategoryDTO;
import br.com.ifs.edu.guarda_sementes.dtos.stock_categories.ResponseStockCategoryDTO;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordAlreadyExistsException;
import br.com.ifs.edu.guarda_sementes.models.StockCategoryModel;
import br.com.ifs.edu.guarda_sementes.repositories.IStockCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockCategoryService {

    private final IStockCategoryRepository stockCategoryRepository;

    public StockCategoryService(IStockCategoryRepository stockCategoryRepository) {
        this.stockCategoryRepository = stockCategoryRepository;
    }

    public List<ResponseStockCategoryDTO> list() {
        return this.stockCategoryRepository.findAll().stream().map(ResponseStockCategoryDTO::new).collect(Collectors.toList());
    }

    public ResponseStockCategoryDTO create(CreateStockCategoryDTO createStockCategoryDTO) {
        var oldStockCategory = this.stockCategoryRepository.findByName(createStockCategoryDTO.getName());

        if (oldStockCategory != null) {
            throw new RecordAlreadyExistsException("Stock Category already exists");
        }

        StockCategoryModel stockCategory = new StockCategoryModel(createStockCategoryDTO.getName());

        return new ResponseStockCategoryDTO(this.stockCategoryRepository.save(stockCategory));
    }
}
