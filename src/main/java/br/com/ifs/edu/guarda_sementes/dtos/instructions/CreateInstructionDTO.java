package br.com.ifs.edu.guarda_sementes.dtos.instructions;

import lombok.Data;

@Data
public class CreateInstructionDTO {

    private String title;
    private String message;

    public CreateInstructionDTO() {
    }

    public CreateInstructionDTO(String title, String message) {
        this.title = title;
        this.message = message;
    }

}
