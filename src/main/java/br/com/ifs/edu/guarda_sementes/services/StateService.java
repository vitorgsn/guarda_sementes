package br.com.ifs.edu.guarda_sementes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ifs.edu.guarda_sementes.dtos.state.CreateStateDTO;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordAlreadyExistsException;
import br.com.ifs.edu.guarda_sementes.models.StateModel;
import br.com.ifs.edu.guarda_sementes.repositories.IStateRepository;

@Service
public class StateService {

    private final IStateRepository stateRepository;

    public StateService(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public StateModel create(CreateStateDTO stateDTO) {

        var oldState = this.stateRepository.findByName(stateDTO.getName());
        if (oldState != null) {
            throw new RecordAlreadyExistsException("State already exists.");
        }

        return this.stateRepository.save(new StateModel(stateDTO.getName()));
    }

    public List<StateModel> list() {
        return this.stateRepository.findAll();
    }

}
