package br.com.ifs.edu.guarda_sementes.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class GuardianDTO {

    private UUID userId;

    public GuardianDTO() {

    }

    public GuardianDTO(UUID userId) {
        this.userId = userId;
    }
}
