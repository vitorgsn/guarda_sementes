package br.com.ifs.edu.guarda_sementes.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity(name = "addresses")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String district;

    @NotNull
    private String street;

    @NotNull
    private String number;

    @NotNull
    private String reference;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonManagedReference
    private CityModel city;

    @OneToOne()
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserModel user;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    public AddressModel() {
    }

    public AddressModel(String district, String street, String number, String reference, CityModel city,
            UserModel user) {
        this.district = district;
        this.street = street;
        this.number = number;
        this.reference = reference;
        this.city = city;
        this.user = user;
    }
}
