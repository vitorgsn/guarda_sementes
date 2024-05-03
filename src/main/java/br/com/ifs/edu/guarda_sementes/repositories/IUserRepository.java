package br.com.ifs.edu.guarda_sementes.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifs.edu.guarda_sementes.models.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByEmail(String email);
}