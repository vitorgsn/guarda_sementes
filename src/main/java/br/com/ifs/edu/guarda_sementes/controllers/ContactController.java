package br.com.ifs.edu.guarda_sementes.controllers;

import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import br.com.ifs.edu.guarda_sementes.dtos.contact.CreateContactDTO;
import br.com.ifs.edu.guarda_sementes.dtos.contact.ResponseContactDTO;
import br.com.ifs.edu.guarda_sementes.services.ContactService;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/contacts")
@Tag(name = "Contacts", description = "Operações relacionadas aos contatos dos usuários")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ResponseContactDTO> list() {
        return this.contactService.list();
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ResponseContactDTO> findByUserId(@PathVariable @NotNull UUID userId ) {
        return this.contactService.findByUserId(userId);
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseContactDTO create(@RequestBody @Valid CreateContactDTO contactDTO) {
        return this.contactService.create(contactDTO);
    }

}
