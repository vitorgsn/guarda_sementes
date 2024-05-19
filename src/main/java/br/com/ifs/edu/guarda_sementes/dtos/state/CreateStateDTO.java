package br.com.ifs.edu.guarda_sementes.dtos.state;

import lombok.Data;

@Data
public class CreateStateDTO {

    private String name;

    public CreateStateDTO() {

    }

    public CreateStateDTO(String name) {
        this.name = name;
    }

}
