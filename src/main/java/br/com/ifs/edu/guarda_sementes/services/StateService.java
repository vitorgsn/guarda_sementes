package br.com.ifs.edu.guarda_sementes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ifs.edu.guarda_sementes.exceptions.RecordAlreadyExistsException;
import br.com.ifs.edu.guarda_sementes.models.StateModel;
import br.com.ifs.edu.guarda_sementes.repositories.IStateRepository;

@Service
public class StateService {

    private final IStateRepository stateRepository;

    public StateService(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public StateModel create(StateModel stateModel) {

        var oldState = this.stateRepository.findByName(stateModel.getName());
        if (oldState != null) {
            throw new RecordAlreadyExistsException("State already exists.");
        }

        return this.stateRepository.save(stateModel);
    }

    public List<StateModel> list() {
        return this.stateRepository.findAll();
    }

}
