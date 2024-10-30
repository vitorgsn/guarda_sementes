package br.com.ifs.edu.guarda_sementes.controllers;

import br.com.ifs.edu.guarda_sementes.dtos.stock_categories.CreateStockCategoryDTO;
import br.com.ifs.edu.guarda_sementes.dtos.stock_categories.ResponseStockCategoryDTO;
import br.com.ifs.edu.guarda_sementes.services.StockCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/stock_categories")
@Tag(name = "Stock Categories", description = "Operações relacionadas as categorias de estoques de sementes")
public class StockCategoryController {

    private final StockCategoryService stockCategoryService;

    public StockCategoryController(StockCategoryService stockCategoryService) {
        this.stockCategoryService = stockCategoryService;
    }

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ResponseStockCategoryDTO> list() {return this.stockCategoryService.list();}

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseStockCategoryDTO create(@RequestBody @Valid CreateStockCategoryDTO createStockCategoryDTO) {
        return this.stockCategoryService.create(createStockCategoryDTO);
    }
}
