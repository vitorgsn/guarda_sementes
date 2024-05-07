package br.com.ifs.edu.guarda_sementes.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.ifs.edu.guarda_sementes.exceptions.RecordAlreadyExistsException;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordNotFoundException;
import br.com.ifs.edu.guarda_sementes.models.UserModel;
import br.com.ifs.edu.guarda_sementes.repositories.IUserRepository;

@Service
public class UserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> list() {
        return this.userRepository.findAll();
    }

    public UserModel findById(UUID id) {
        return this.userRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("User not found."));
    }

    public UserModel create(UserModel userModel) {

        var oldUser = this.userRepository.findByEmail(userModel.getEmail());
        if (oldUser != null) {
            throw new RecordAlreadyExistsException("Email address already exists.");
        }

        return this.userRepository.save(userModel);
    }

    public UserModel update(UUID id, UserModel userModel) {

        var oldUser = this.userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("User not found."));

        oldUser.setName(userModel.getName());
        oldUser.setPassword(userModel.getPassword());

        return this.userRepository.save(oldUser);
    }

    public void delete(UUID id) {
        var oldUser = this.userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("User not found."));

        this.userRepository.delete(oldUser);
    }
}
