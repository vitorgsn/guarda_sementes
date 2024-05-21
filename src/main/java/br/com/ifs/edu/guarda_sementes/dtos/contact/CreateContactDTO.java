package br.com.ifs.edu.guarda_sementes.dtos.contact;

import java.util.UUID;

import lombok.Data;

@Data
public class CreateContactDTO {

    private String email;
    private String phone;
    private UUID userId;

    public CreateContactDTO() {
    }

    public CreateContactDTO(String email, String phone, UUID userId) {
        this.email = email;
        this.phone = phone;
        this.userId = userId;
    }

}
