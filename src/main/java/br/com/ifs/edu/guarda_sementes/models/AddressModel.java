package br.com.ifs.edu.guarda_sementes.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

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
    private CityModel city;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserModel user;
}
