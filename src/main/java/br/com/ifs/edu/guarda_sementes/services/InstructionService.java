package br.com.ifs.edu.guarda_sementes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.ifs.edu.guarda_sementes.dtos.instructions.CreateInstructionDTO;
import br.com.ifs.edu.guarda_sementes.dtos.instructions.ResponseInstructionDTO;
import br.com.ifs.edu.guarda_sementes.models.InstructionModel;
import br.com.ifs.edu.guarda_sementes.repositories.IInstructionRepository;

@Service
public class InstructionService {

    private final IInstructionRepository instructionRepository;

    public InstructionService(IInstructionRepository instructionRepository) {
        this.instructionRepository = instructionRepository;
    }

    public List<ResponseInstructionDTO> list() {
        return this.instructionRepository.findAll().stream().map(ResponseInstructionDTO::new)
                .collect(Collectors.toList());
    }

    public ResponseInstructionDTO create(CreateInstructionDTO instructionDTO) {

        InstructionModel instruction = new InstructionModel(instructionDTO.getTitle(), instructionDTO.getMessage());

        return new ResponseInstructionDTO(this.instructionRepository.save(instruction));
    }

}
