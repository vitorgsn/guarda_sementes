package br.com.ifs.edu.guarda_sementes.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifs.edu.guarda_sementes.dtos.instructions.CreateInstructionDTO;
import br.com.ifs.edu.guarda_sementes.dtos.instructions.ResponseInstructionDTO;
import br.com.ifs.edu.guarda_sementes.services.InstructionService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/instructions")
public class InstructionController {

    private final InstructionService instructionService;

    public InstructionController(InstructionService instructionService) {
        this.instructionService = instructionService;
    }

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ResponseInstructionDTO> list() {
        return this.instructionService.list();
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseInstructionDTO create(@RequestBody CreateInstructionDTO instructionDTO) {
        return this.instructionService.create(instructionDTO);
    }

}
