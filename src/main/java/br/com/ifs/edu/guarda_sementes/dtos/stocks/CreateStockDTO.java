package br.com.ifs.edu.guarda_sementes.dtos.stocks;

import br.com.ifs.edu.guarda_sementes.enums.StockCategory;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateStockDTO {

    private StockCategory category;
    private UUID userId;

    public CreateStockDTO() {
    }

    public CreateStockDTO(StockCategory category, UUID userId) {
        this.category = category;
        this.userId = userId;
    }
}
