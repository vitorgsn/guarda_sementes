package br.com.ifs.edu.guarda_sementes.repositories;

import br.com.ifs.edu.guarda_sementes.models.StockCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockCategoryRepository extends JpaRepository<StockCategoryModel, Integer> {
    StockCategoryModel findByName(String name);
}
