package br.com.ifs.edu.guarda_sementes.dtos.seeds;

import lombok.Data;

@Data
public class CreateSeedDTO {

    private String name;
    private Float amount;
    private String description;
    private int stockId;

    public CreateSeedDTO() {}

    public CreateSeedDTO(String name, Float amount, String description, int stockId) {
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.stockId = stockId;
    }
}
