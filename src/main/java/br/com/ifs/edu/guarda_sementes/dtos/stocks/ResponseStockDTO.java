package br.com.ifs.edu.guarda_sementes.dtos.stocks;

import br.com.ifs.edu.guarda_sementes.enums.StockCategory;
import br.com.ifs.edu.guarda_sementes.models.StockModel;
import lombok.Data;

@Data
public class ResponseStockDTO {

    private int id;
    private StockCategory category;

    public ResponseStockDTO() {
    }

    public ResponseStockDTO(StockModel stockModel) {
        this.id = stockModel.getId();
        this.category = stockModel.getCategory();
    }
}
