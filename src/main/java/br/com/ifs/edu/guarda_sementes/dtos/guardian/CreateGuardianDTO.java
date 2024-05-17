package br.com.ifs.edu.guarda_sementes.dtos.guardian;

import java.util.UUID;

import lombok.Data;

@Data
public class CreateGuardianDTO {

    private UUID userId;

    public CreateGuardianDTO() {

    }

    public CreateGuardianDTO(UUID userId) {
        this.userId = userId;
    }
}
