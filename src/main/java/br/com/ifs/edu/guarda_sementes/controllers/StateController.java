package br.com.ifs.edu.guarda_sementes.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifs.edu.guarda_sementes.dtos.state.CreateStateDTO;
import br.com.ifs.edu.guarda_sementes.dtos.state.ResponseStateDTO;
import br.com.ifs.edu.guarda_sementes.services.StateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@Validated
@RestController
@RequestMapping("/api/states")
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<ResponseStateDTO> list() {
        return this.stateService.list().stream().map(ResponseStateDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseStateDTO create(@RequestBody CreateStateDTO stateDTO) {
        return new ResponseStateDTO(this.stateService.create(stateDTO));
    }

}
