package br.com.ifs.edu.guarda_sementes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifs.edu.guarda_sementes.models.StateModel;

@Repository
public interface IStateRepository extends JpaRepository<StateModel, Integer> {

    StateModel findByName(String name);
}
