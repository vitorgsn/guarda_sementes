package br.com.ifs.edu.guarda_sementes.dtos.contact;

import br.com.ifs.edu.guarda_sementes.models.ContactModel;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseContactDTO {

    private int id;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public ResponseContactDTO() {
    }

    public ResponseContactDTO(ContactModel contactModel) {
        this.id = contactModel.getId();
        this.email = contactModel.getEmail();
        this.phone = contactModel.getPhone();
        this.createdAt = contactModel.getCreatedAt();
        this.updateAt = contactModel.getUpdateAt();
    }

}
