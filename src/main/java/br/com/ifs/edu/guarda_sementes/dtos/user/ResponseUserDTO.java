package br.com.ifs.edu.guarda_sementes.dtos.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.ifs.edu.guarda_sementes.dtos.address.ResponseAddressDTO;
import br.com.ifs.edu.guarda_sementes.dtos.contact.ResponseContactDTO;
import br.com.ifs.edu.guarda_sementes.enums.UserRole;
import br.com.ifs.edu.guarda_sementes.models.UserModel;
import lombok.Data;

@Data
public class ResponseUserDTO {

    private UUID id;
    private String name;
    private String email;
    private UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public ResponseUserDTO(UserModel userModel) {

        this.id = userModel.getId();
        this.name = userModel.getName();
        this.email = userModel.getEmail();
        this.role = userModel.getRole();
        this.createdAt = userModel.getCreatedAt();
        this.updateAt = userModel.getUpdateAt();
    }

}
