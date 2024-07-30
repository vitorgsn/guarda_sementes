package br.com.ifs.edu.guarda_sementes.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

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
