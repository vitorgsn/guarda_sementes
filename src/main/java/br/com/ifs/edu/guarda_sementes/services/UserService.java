package br.com.ifs.edu.guarda_sementes.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

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

    public Optional<UserModel> findById(UUID id) {
        return userRepository.findById(id);
    }

    public UserModel create(UserModel userModel) {
        return this.userRepository.save(userModel);
    }
}
