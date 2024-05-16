package br.com.ifs.edu.guarda_sementes.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifs.edu.guarda_sementes.models.GuardianModel;

@Repository
public interface IGuardianRepository extends JpaRepository<GuardianModel, Integer> {
    GuardianModel findByUserId(UUID userId);
}
