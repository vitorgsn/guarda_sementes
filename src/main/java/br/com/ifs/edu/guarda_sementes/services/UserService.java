package br.com.ifs.edu.guarda_sementes.services;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import br.com.ifs.edu.guarda_sementes.enums.Role;
import br.com.ifs.edu.guarda_sementes.repositories.IRoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ifs.edu.guarda_sementes.dtos.user.CreateUserDTO;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordAlreadyExistsException;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordNotFoundException;
import br.com.ifs.edu.guarda_sementes.models.UserModel;
import br.com.ifs.edu.guarda_sementes.repositories.IUserRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final IRoleRepository roleRepository;

    public UserService(IUserRepository userRepository, BCryptPasswordEncoder passwordEncoder, IRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public List<UserModel> list() {
        return this.userRepository.findAll();
    }

    public UserModel findById(UUID id) {
        return this.userRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("User not found."));
    }

    @Transactional
    public UserModel create(CreateUserDTO userDTO) {

        var userRole = roleRepository.findByName(Role.USER.name());

        var oldUser = this.userRepository.findByEmail(userDTO.getEmail());
        if (oldUser.isPresent()) {
            throw new RecordAlreadyExistsException("Email address already exists.");
        }

        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());

        var user = new UserModel();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(encryptedPassword);
        user.setRoles(Set.of(userRole));

        return this.userRepository.save(user);
    }

    public UserModel update(UUID id, UserModel userModel) {

        var oldUser = this.userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("User not found."));

        oldUser.setFirstName(userModel.getFirstName());
        oldUser.setLastName(userModel.getLastName());
        oldUser.setPassword(userModel.getPassword());

        return this.userRepository.save(oldUser);
    }

    public void delete(UUID id) {
        var oldUser = this.userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("User not found."));

        this.userRepository.delete(oldUser);
    }

}
