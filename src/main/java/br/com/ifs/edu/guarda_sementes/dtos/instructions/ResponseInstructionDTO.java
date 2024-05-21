package br.com.ifs.edu.guarda_sementes.dtos.instructions;

import br.com.ifs.edu.guarda_sementes.models.InstructionModel;
import lombok.Data;

@Data
public class ResponseInstructionDTO {

    private int id;
    private String title;
    private String message;

    public ResponseInstructionDTO() {
    }

    public ResponseInstructionDTO(InstructionModel instructionModel) {
        this.id = instructionModel.getId();
        this.title = instructionModel.getTitle();
        this.message = instructionModel.getMessage();
    }

}
