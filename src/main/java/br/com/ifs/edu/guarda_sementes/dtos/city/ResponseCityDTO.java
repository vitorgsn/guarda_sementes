package br.com.ifs.edu.guarda_sementes.dtos.city;

import br.com.ifs.edu.guarda_sementes.models.CityModel;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseCityDTO {

    private int id;
    private String name;
    private String state;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public ResponseCityDTO(CityModel cityModel) {
        this.id = cityModel.getId();
        this.name = cityModel.getName();
        this.state = cityModel.getState().getName();
        this.createdAt = cityModel.getCreatedAt();
        this.updateAt = cityModel.getUpdateAt();
    }

}
