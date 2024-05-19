package br.com.ifs.edu.guarda_sementes.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifs.edu.guarda_sementes.dtos.address.CreateAddressDTO;
import br.com.ifs.edu.guarda_sementes.dtos.address.ResponseAddressDTO;
import br.com.ifs.edu.guarda_sementes.services.AddressService;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseAddressDTO findByUserId(@PathVariable @NotNull UUID userId) {
        return new ResponseAddressDTO(this.addressService.findByUserId(userId));
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseAddressDTO create(@RequestBody CreateAddressDTO addressDTO) {
        return new ResponseAddressDTO(this.addressService.create(addressDTO));
    }

}
