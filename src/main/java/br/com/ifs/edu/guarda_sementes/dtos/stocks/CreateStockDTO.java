package br.com.ifs.edu.guarda_sementes.dtos.stocks;

import br.com.ifs.edu.guarda_sementes.models.StockCategoryModel;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateStockDTO {

    private int category;
    private UUID userId;

    public CreateStockDTO() {
    }

    public CreateStockDTO(int category, UUID userId) {
        this.category = category;
        this.userId = userId;
    }
}
