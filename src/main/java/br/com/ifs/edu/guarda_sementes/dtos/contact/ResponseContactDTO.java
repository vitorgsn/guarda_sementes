package br.com.ifs.edu.guarda_sementes.dtos.contact;

import br.com.ifs.edu.guarda_sementes.models.ContactModel;
import lombok.Data;

@Data
public class ResponseContactDTO {

    private int id;
    private String email;
    private String phone;

    public ResponseContactDTO() {
    }

    public ResponseContactDTO(ContactModel contactModel) {
        this.id = contactModel.getId();
        this.email = contactModel.getEmail();
        this.phone = contactModel.getPhone();
    }

}
