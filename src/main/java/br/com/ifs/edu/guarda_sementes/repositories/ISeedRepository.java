package br.com.ifs.edu.guarda_sementes.repositories;

import br.com.ifs.edu.guarda_sementes.models.SeedModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeedRepository extends JpaRepository<SeedModel, Integer> {

    SeedModel findByName(String name);

}
