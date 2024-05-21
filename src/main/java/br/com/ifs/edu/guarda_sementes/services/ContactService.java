package br.com.ifs.edu.guarda_sementes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.ifs.edu.guarda_sementes.dtos.contact.CreateContactDTO;
import br.com.ifs.edu.guarda_sementes.dtos.contact.ResponseContactDTO;
import br.com.ifs.edu.guarda_sementes.exceptions.RecordNotFoundException;
import br.com.ifs.edu.guarda_sementes.models.ContactModel;
import br.com.ifs.edu.guarda_sementes.repositories.IContactRepository;
import br.com.ifs.edu.guarda_sementes.repositories.IUserRepository;

@Service
public class ContactService {

    private final IContactRepository contactRepository;
    private final IUserRepository userRepository;

    public ContactService(IContactRepository contactRepository, IUserRepository userRepository) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
    }

    public List<ResponseContactDTO> list() {
        return this.contactRepository.findAll().stream().map(ResponseContactDTO::new).collect(Collectors.toList());
    }

    public ResponseContactDTO create(CreateContactDTO contactDTO) {

        var oldUser = this.userRepository.findById(contactDTO.getUserId())
                .orElseThrow(() -> new RecordNotFoundException("User not found."));

        ContactModel contact = new ContactModel(contactDTO.getEmail(), contactDTO.getPhone(), oldUser);

        return new ResponseContactDTO(this.contactRepository.save(contact));
    }

}
