package br.com.ifs.edu.guarda_sementes.repositories;

import br.com.ifs.edu.guarda_sementes.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleModel, Integer> {
    RoleModel findByName(String name);
}
