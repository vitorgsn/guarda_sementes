package br.com.ifs.edu.guarda_sementes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifs.edu.guarda_sementes.models.UserModel;
import br.com.ifs.edu.guarda_sementes.repositories.IUserRepository;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public Object create(UserModel userModel) {

        var oldUser = this.userRepository.findByEmail(userModel.getEmail());

        if (oldUser != null) {
            return null;
        }

        var userCreated = this.userRepository.save(userModel);

        return userCreated;
    }
}
