package br.com.ifs.edu.guarda_sementes.dtos.stocks;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateStockDTO {

    private String name;
    private UUID userId;

    public CreateStockDTO() {
    }

    public CreateStockDTO(String name, UUID userId) {
        this.name = name;
        this.userId = userId;
    }
}
