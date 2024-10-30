package br.com.ifs.edu.guarda_sementes.controllers;

import java.util.List;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifs.edu.guarda_sementes.dtos.city.CreateCityDTO;
import br.com.ifs.edu.guarda_sementes.dtos.city.ResponseCityDTO;
import br.com.ifs.edu.guarda_sementes.services.CityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
@RestController
@RequestMapping("/cities")
@Tag(name = "Cities", description = "Operações relacionadas as cidades")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ResponseCityDTO> list() {
        return this.cityService.list().stream().map(ResponseCityDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseCityDTO create(@RequestBody CreateCityDTO cityDTO) {
        return new ResponseCityDTO(this.cityService.create(cityDTO));
    }

}
