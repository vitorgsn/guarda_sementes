package br.com.ifs.edu.guarda_sementes.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
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
    @JsonManagedReference
    private CityModel city;

    @OneToOne()
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserModel user;

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
