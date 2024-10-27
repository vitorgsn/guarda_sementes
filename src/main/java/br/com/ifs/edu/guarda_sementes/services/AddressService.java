package br.com.ifs.edu.guarda_sementes.services;

import java.util.UUID;

import br.com.ifs.edu.guarda_sementes.dtos.address.ResponseAddressDTO;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordAlreadyExistsException;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import br.com.ifs.edu.guarda_sementes.dtos.address.CreateAddressDTO;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordNotFoundException;
import br.com.ifs.edu.guarda_sementes.models.AddressModel;
import br.com.ifs.edu.guarda_sementes.repositories.IAddressRepository;
import br.com.ifs.edu.guarda_sementes.repositories.ICityRepository;
import br.com.ifs.edu.guarda_sementes.repositories.IUserRepository;

@Service
public class AddressService {

    private final IAddressRepository addressRepository;
    private final ICityRepository cityRepository;
    private final IUserRepository userRepository;

    public AddressService(IAddressRepository addressRepository, ICityRepository cityRepository,
            IUserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.cityRepository = cityRepository;
        this.userRepository = userRepository;
    }

    public ResponseAddressDTO listAddressUser(JwtAuthenticationToken token) {

        var userAuthenticated = UUID.fromString(token.getName());

        var oldUser = this.userRepository.findById(userAuthenticated).orElseThrow(() -> new RecordNotFoundException("User not found."));

        var oldAddress = addressRepository.findByUserId(userAuthenticated);

        if (oldAddress == null) {
            throw new RecordNotFoundException("The user does not have registered addresses.");
        }

        return new ResponseAddressDTO(oldAddress);
    }

    public AddressModel create(CreateAddressDTO addressDTO, JwtAuthenticationToken token) {

        var userAuthenticated = UUID.fromString(token.getName());

        var oldAddress = addressRepository.findByUserId(userAuthenticated);

        if (oldAddress != null) {
            throw new RecordAlreadyExistsException("The address already exists.");
        }

        var oldCity = this.cityRepository.findById(addressDTO.getCityId())
                .orElseThrow(() -> new RecordNotFoundException("City not found."));

        var oldUser = this.userRepository.findById(userAuthenticated)
                .orElseThrow(() -> new RecordNotFoundException("User not found."));

        AddressModel address = new AddressModel(addressDTO.getDistrict(), addressDTO.getStreet(),
                addressDTO.getNumber(), addressDTO.getReference(), oldCity, oldUser);

        return this.addressRepository.save(address);
    }

}
