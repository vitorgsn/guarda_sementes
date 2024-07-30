package br.com.ifs.edu.guarda_sementes.dtos.stocks;

import br.com.ifs.edu.guarda_sementes.dtos.stock_categories.ResponseStockCategoryDTO;
import br.com.ifs.edu.guarda_sementes.models.StockCategoryModel;
import br.com.ifs.edu.guarda_sementes.models.StockModel;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseStockDTO {

    private int id;
    private ResponseStockCategoryDTO category;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public ResponseStockDTO() {
    }

    public ResponseStockDTO(StockModel stockModel) {
        this.id = stockModel.getId();
        this.category = new ResponseStockCategoryDTO(stockModel.getCategory());
        this.createdAt = stockModel.getCreatedAt();
        this.updateAt = stockModel.getUpdateAt();
    }
}
