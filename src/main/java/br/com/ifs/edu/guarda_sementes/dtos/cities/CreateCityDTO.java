package br.com.ifs.edu.guarda_sementes.dtos.cities;

import lombok.Data;

@Data
public class CreateCityDTO {

    private String name;

    private int stateId;

    public CreateCityDTO() {

    }

    public CreateCityDTO(String name, int stateId) {
        this.name = name;
        this.stateId = stateId;
    }
}
