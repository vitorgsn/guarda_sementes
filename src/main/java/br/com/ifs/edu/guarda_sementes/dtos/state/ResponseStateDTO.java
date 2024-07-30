package br.com.ifs.edu.guarda_sementes.dtos.state;

import br.com.ifs.edu.guarda_sementes.models.StateModel;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseStateDTO {

    private int id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public ResponseStateDTO(StateModel stateModel) {
        this.id = stateModel.getId();
        this.name = stateModel.getName();
        this.createdAt = stateModel.getCreatedAt();
        this.updateAt = stateModel.getUpdateAt();
    }

}
