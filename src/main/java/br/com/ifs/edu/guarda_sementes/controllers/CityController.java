package br.com.ifs.edu.guarda_sementes.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifs.edu.guarda_sementes.dtos.cities.CreateCityDTO;
import br.com.ifs.edu.guarda_sementes.models.CityModel;
import br.com.ifs.edu.guarda_sementes.services.CityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<CityModel> list() {
        return this.cityService.list();
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CityModel create(@RequestBody CreateCityDTO cityDTO) {
        return this.cityService.create(cityDTO);
    }

}
