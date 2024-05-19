package br.com.ifs.edu.guarda_sementes.dtos.user;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.ifs.edu.guarda_sementes.dtos.address.ResponseAddressDTO;
import br.com.ifs.edu.guarda_sementes.models.UserModel;
import lombok.Data;

@Data
public class ResponseUserDTO {

    private UUID id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private ResponseAddressDTO address;

    public ResponseUserDTO(UserModel userModel) {

        this.id = userModel.getId();
        this.name = userModel.getName();
        this.email = userModel.getEmail();
        this.createdAt = userModel.getCreatedAt();
        this.updateAt = userModel.getUpdateAt();

        if (userModel.getAddress() == null) {
            this.address = null;
        } else {
            this.address = new ResponseAddressDTO(userModel.getAddress());
        }
    }

}
