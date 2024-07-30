package br.com.ifs.edu.guarda_sementes.dtos.stock_categories;

import br.com.ifs.edu.guarda_sementes.models.StockCategoryModel;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseStockCategoryDTO {

    private int id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public ResponseStockCategoryDTO() {
    }

    public ResponseStockCategoryDTO(StockCategoryModel categoryModel) {
        this.id = categoryModel.getId();
        this.name = categoryModel.getName();
        this.createdAt = categoryModel.getCreatedAt();
        this.updateAt = categoryModel.getUpdateAt();
    }
}
