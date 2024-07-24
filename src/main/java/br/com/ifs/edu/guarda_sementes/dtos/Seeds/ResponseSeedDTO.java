package br.com.ifs.edu.guarda_sementes.dtos.Seeds;

import br.com.ifs.edu.guarda_sementes.models.SeedModel;
import lombok.Data;

@Data
public class ResponseSeedDTO {

    private int id;
    private String name;
    private Float amount;
    private String description;
    private String stock;

    public ResponseSeedDTO(SeedModel seedModel) {
        this.id = seedModel.getId();
        this.name = seedModel.getName();
        this.amount = seedModel.getAmount();
        this.description = seedModel.getDescription();
        this.stock = seedModel.getStock().getCategory().getCategory();
    }
}
