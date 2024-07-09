package br.com.ifs.edu.guarda_sementes.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "seeds")
public class SeedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    private Float amount;

    private String description;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    @JsonBackReference
    private StockModel stock;

    public SeedModel() {}

    public SeedModel(String name, Float amount, String description, StockModel stock) {
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.stock = stock;
    }
}
