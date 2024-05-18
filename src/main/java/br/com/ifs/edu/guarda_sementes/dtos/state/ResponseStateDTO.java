package br.com.ifs.edu.guarda_sementes.dtos.state;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ifs.edu.guarda_sementes.dtos.city.ResponseCityDTO;
import br.com.ifs.edu.guarda_sementes.models.StateModel;
import lombok.Data;

@Data
public class ResponseStateDTO {

    private int id;
    private String name;
    private List<ResponseCityDTO> cities;

    public ResponseStateDTO(StateModel stateModel) {
        this.id = stateModel.getId();
        this.name = stateModel.getName();
        this.cities = stateModel.getCities().stream().map(ResponseCityDTO::new).collect(Collectors.toList());
    }

}
