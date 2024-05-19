package br.com.ifs.edu.guarda_sementes.services;

import java.util.UUID;

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

    public AddressModel findByUserId(UUID userId) {

        var oldAddress = this.addressRepository.findByUserId(userId);
        if (oldAddress == null) {
            throw new RecordNotFoundException("The user does not have a registered address.");
        }

        return oldAddress;
    }

    public AddressModel create(CreateAddressDTO addressDTO) {

        var oldCity = this.cityRepository.findById(addressDTO.getCityId())
                .orElseThrow(() -> new RecordNotFoundException("City not found."));

        var oldUser = this.userRepository.findById(addressDTO.getUserId())
                .orElseThrow(() -> new RecordNotFoundException("User not found."));

        AddressModel address = new AddressModel(addressDTO.getDistrict(), addressDTO.getStreet(),
                addressDTO.getNumber(), addressDTO.getReference(), oldCity, oldUser);

        return this.addressRepository.save(address);
    }

}
