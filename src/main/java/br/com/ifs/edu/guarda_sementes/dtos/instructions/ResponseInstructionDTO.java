package br.com.ifs.edu.guarda_sementes.dtos.instructions;

import br.com.ifs.edu.guarda_sementes.models.InstructionModel;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseInstructionDTO {

    private int id;
    private String title;
    private String message;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public ResponseInstructionDTO() {
    }

    public ResponseInstructionDTO(InstructionModel instructionModel) {
        this.id = instructionModel.getId();
        this.title = instructionModel.getTitle();
        this.message = instructionModel.getMessage();
        this.createdAt = instructionModel.getCreatedAt();
        this.updateAt = instructionModel.getUpdateAt();
    }

}
