package br.com.ifs.edu.guarda_sementes.repositories;

import br.com.ifs.edu.guarda_sementes.models.ExchangeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IExchangeRepository extends JpaRepository<ExchangeModel, UUID> {
}
