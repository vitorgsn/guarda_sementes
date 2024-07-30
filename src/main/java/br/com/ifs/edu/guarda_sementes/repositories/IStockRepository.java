package br.com.ifs.edu.guarda_sementes.repositories;

import br.com.ifs.edu.guarda_sementes.models.StockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepository extends JpaRepository<StockModel, Integer> {
}
