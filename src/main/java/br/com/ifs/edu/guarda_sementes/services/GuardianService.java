package br.com.ifs.edu.guarda_sementes.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.ifs.edu.guarda_sementes.dtos.guardian.CreateGuardianDTO;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordAlreadyExistsException;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordNotFoundException;
import br.com.ifs.edu.guarda_sementes.models.GuardianModel;
import br.com.ifs.edu.guarda_sementes.repositories.IGuardianRepository;
import br.com.ifs.edu.guarda_sementes.repositories.IUserRepository;

@Service
public class GuardianService {

    private final IGuardianRepository guardianRepository;
    private final IUserRepository userRepository;

    public GuardianService(IGuardianRepository guardianRepository, IUserRepository userRepository) {
        this.guardianRepository = guardianRepository;
        this.userRepository = userRepository;
    }

    public List<GuardianModel> list() {
        return this.guardianRepository.findAll();
    }

    public GuardianModel create(CreateGuardianDTO guardianDTO) {

        var oldGuardian = this.guardianRepository.findByUserId(guardianDTO.getUserId());
        if (oldGuardian != null) {
            throw new RecordAlreadyExistsException("Guardian address already exists.");
        }

        var oldUser = this.userRepository.findById(guardianDTO.getUserId())
                .orElseThrow(() -> new RecordNotFoundException("User not found."));

        GuardianModel guardian = new GuardianModel();

        guardian.setUser(oldUser);

        return this.guardianRepository.save(guardian);
    }

    public GuardianModel findByUserId(UUID userId) {
        var oldGuardian = this.guardianRepository.findByUserId(userId);

        if (oldGuardian == null) {
            throw new RecordNotFoundException("Guardian not found.");
        }

        return oldGuardian;
    }
}
