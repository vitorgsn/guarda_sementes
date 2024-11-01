package br.com.ifs.edu.guarda_sementes.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifs.edu.guarda_sementes.models.AddressModel;

@Repository
public interface IAddressRepository extends JpaRepository<AddressModel, Integer> {

    AddressModel findByUserId(UUID userId);

}
