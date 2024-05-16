package br.com.ifs.edu.guarda_sementes.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.ifs.edu.guarda_sementes.dtos.GuardianDTO;
import br.com.ifs.edu.guarda_sementes.models.GuardianModel;
import br.com.ifs.edu.guarda_sementes.services.GuardianService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
@RestController
@RequestMapping("/api/guardians")
public class GuardianController {

    private final GuardianService guardianService;

    public GuardianController(GuardianService guardianService) {
        this.guardianService = guardianService;
    }

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<GuardianModel> list() {
        return this.guardianService.list();
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public GuardianModel create(@RequestBody @Valid GuardianDTO guardianDTO) {
        return this.guardianService.create(guardianDTO);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.OK)
    public GuardianModel findByUserId(@PathVariable @NotNull UUID userId) {
        return this.guardianService.findByUserId(userId);
    }
}
