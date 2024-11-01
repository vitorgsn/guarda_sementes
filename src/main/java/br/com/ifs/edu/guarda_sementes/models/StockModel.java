package br.com.ifs.edu.guarda_sementes.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "stocks")
public class StockModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "stock_category_id")
    private StockCategoryModel category;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserModel user;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SeedModel> seeds;

    public StockModel() {
    }

    public StockModel(StockCategoryModel category, UserModel user) {
        this.category = category;
        this.user = user;
    }
}
