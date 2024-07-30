package br.com.ifs.edu.guarda_sementes.controllers;

import br.com.ifs.edu.guarda_sementes.dtos.seeds.CreateSeedDTO;
import br.com.ifs.edu.guarda_sementes.dtos.seeds.ResponseSeedDTO;
import br.com.ifs.edu.guarda_sementes.services.SeedService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/seeds")
public class SeedController {

    private final SeedService seedService;

    public SeedController(SeedService seedService) {
        this.seedService = seedService;
    }

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ResponseSeedDTO> list() {
        return this.seedService.list();
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseSeedDTO create(@RequestBody @Valid CreateSeedDTO createSeedDTO) {
        return this.seedService.create(createSeedDTO);
    }
}
