package br.com.ifs.edu.guarda_sementes.dtos.stock_categories;

import lombok.Data;

@Data
public class CreateStockCategoryDTO {

    private String name;

    public CreateStockCategoryDTO() {

    }

    public CreateStockCategoryDTO(String name) {
        this.name = name;
    }
}
