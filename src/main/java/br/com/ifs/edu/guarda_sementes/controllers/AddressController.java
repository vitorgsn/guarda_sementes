package br.com.ifs.edu.guarda_sementes.controllers;

import java.util.UUID;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
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
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/addresses")
@Tag(name = "Addresses", description = "Operações relacionadas aos endereços dos usuários")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseAddressDTO listAddressUser(JwtAuthenticationToken token) {
        return this.addressService.listAddressUser(token);
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseAddressDTO create(@RequestBody @Valid CreateAddressDTO addressDTO, JwtAuthenticationToken token) {
        return new ResponseAddressDTO(this.addressService.create(addressDTO, token));
    }

}
