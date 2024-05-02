package br.com.ifs.edu.guarda_sementes.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifs.edu.guarda_sementes.models.UserModel;

public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByEmail(String email);
}