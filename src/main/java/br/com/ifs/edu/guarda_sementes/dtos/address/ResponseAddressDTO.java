package br.com.ifs.edu.guarda_sementes.dtos.address;

import br.com.ifs.edu.guarda_sementes.dtos.city.ResponseCityDTO;
import br.com.ifs.edu.guarda_sementes.models.AddressModel;
import lombok.Data;

@Data
public class ResponseAddressDTO {

    private int id;
    private String district;
    private String street;
    private String number;
    private String reference;
    private ResponseCityDTO city;

    public ResponseAddressDTO(AddressModel addressModel) {
        this.id = addressModel.getId();
        this.district = addressModel.getDistrict();
        this.street = addressModel.getStreet();
        this.number = addressModel.getNumber();
        this.reference = addressModel.getReference();
        this.city = new ResponseCityDTO(addressModel.getCity());
    }

}
