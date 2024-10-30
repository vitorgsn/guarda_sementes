package br.com.ifs.edu.guarda_sementes.controllers;

import br.com.ifs.edu.guarda_sementes.dtos.stocks.CreateStockDTO;
import br.com.ifs.edu.guarda_sementes.dtos.stocks.ResponseStockDTO;
import br.com.ifs.edu.guarda_sementes.services.StockService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/stocks")
@Tag(name = "Stocks", description = "Operações relacionadas aos estoques de sementes dos usuários")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ResponseStockDTO> list() {return this.stockService.list();}

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseStockDTO create(@RequestBody @Valid CreateStockDTO createStockDTO) {
        return this.stockService.create(createStockDTO);
    }
}
