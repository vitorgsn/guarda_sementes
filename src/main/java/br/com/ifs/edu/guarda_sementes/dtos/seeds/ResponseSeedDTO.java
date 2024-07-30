package br.com.ifs.edu.guarda_sementes.dtos.seeds;

import br.com.ifs.edu.guarda_sementes.dtos.stocks.ResponseStockDTO;
import br.com.ifs.edu.guarda_sementes.models.SeedModel;
import br.com.ifs.edu.guarda_sementes.models.StockModel;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseSeedDTO {

    private int id;
    private String name;
    private Float amount;
    private String description;
    private ResponseStockDTO stock;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public ResponseSeedDTO(SeedModel seedModel) {
        this.id = seedModel.getId();
        this.name = seedModel.getName();
        this.amount = seedModel.getAmount();
        this.description = seedModel.getDescription();
        this.stock = new ResponseStockDTO(seedModel.getStock());
        this.createdAt = seedModel.getCreatedAt();
        this.updateAt = seedModel.getUpdateAt();
    }
}
