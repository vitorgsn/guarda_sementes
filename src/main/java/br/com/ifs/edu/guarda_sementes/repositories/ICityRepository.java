package br.com.ifs.edu.guarda_sementes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifs.edu.guarda_sementes.models.CityModel;

@Repository
public interface ICityRepository extends JpaRepository<CityModel, Integer> {

    CityModel findByName(String name);
}
