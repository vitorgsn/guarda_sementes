package br.com.ifs.edu.guarda_sementes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifs.edu.guarda_sementes.models.ContactModel;

import java.util.List;
import java.util.UUID;

@Repository
public interface IContactRepository extends JpaRepository<ContactModel, Integer> {
    List<ContactModel> findByUserId(UUID userId);
}
