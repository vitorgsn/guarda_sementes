package br.com.ifs.edu.guarda_sementes.dtos.state;

import br.com.ifs.edu.guarda_sementes.models.StateModel;
import lombok.Data;

@Data
public class ResponseStateDTO {

    private int id;
    private String name;

    public ResponseStateDTO(StateModel stateModel) {
        this.id = stateModel.getId();
        this.name = stateModel.getName();
    }

}
