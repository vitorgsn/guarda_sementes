package br.com.ifs.edu.guarda_sementes.dtos.address;

import java.util.UUID;

import lombok.Data;

@Data
public class CreateAddressDTO {

    private String district;
    private String street;
    private String number;
    private String reference;
    private int cityId;

    public CreateAddressDTO() {

    }

    public CreateAddressDTO(String district, String street, String number, String reference, int cityId) {
        this.district = district;
        this.street = street;
        this.number = number;
        this.reference = reference;
        this.cityId = cityId;
    }

}
