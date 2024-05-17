package br.com.ifs.edu.guarda_sementes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ifs.edu.guarda_sementes.dtos.cities.CreateCityDTO;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordAlreadyExistsException;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordNotFoundException;
import br.com.ifs.edu.guarda_sementes.models.CityModel;
import br.com.ifs.edu.guarda_sementes.repositories.ICityRepository;
import br.com.ifs.edu.guarda_sementes.repositories.IStateRepository;

@Service
public class CityService {

    private final ICityRepository cityRepository;

    private final IStateRepository stateRepository;

    public CityService(ICityRepository cityRepository, IStateRepository stateRepository) {
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
    }

    public List<CityModel> list() {
        return this.cityRepository.findAll();
    }

    public CityModel create(CreateCityDTO cityDTO) {

        var oldCity = this.cityRepository.findByName(cityDTO.getName());
        if (oldCity != null) {
            throw new RecordAlreadyExistsException("City already exists.");
        }

        var oldState = this.stateRepository.findById(cityDTO.getStateId())
                .orElseThrow(() -> new RecordNotFoundException("State not found."));

        CityModel city = new CityModel();

        city.setName(cityDTO.getName());
        city.setState(oldState);

        return this.cityRepository.save(city);
    }

}
