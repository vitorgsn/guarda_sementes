package br.com.ifs.edu.guarda_sementes.dtos.city;

import br.com.ifs.edu.guarda_sementes.models.CityModel;
import lombok.Data;

@Data
public class ResponseCityDTO {

    private int id;
    private String name;
    private String state;

    public ResponseCityDTO(CityModel cityModel) {
        this.id = cityModel.getId();
        this.name = cityModel.getName();
        this.state = cityModel.getState().getName();
    }

}
