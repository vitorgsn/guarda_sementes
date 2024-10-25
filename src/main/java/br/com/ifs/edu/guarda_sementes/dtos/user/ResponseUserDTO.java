package br.com.ifs.edu.guarda_sementes.dtos.user;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.ifs.edu.guarda_sementes.models.RoleModel;
import br.com.ifs.edu.guarda_sementes.models.UserModel;
import lombok.Data;

@Data
public class ResponseUserDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public ResponseUserDTO(UserModel userModel) {
        this.id = userModel.getId();
        this.firstName = userModel.getFirstName();
        this.lastName = userModel.getLastName();
        this.email = userModel.getEmail();
        this.role = userModel.getRoles().stream().map(RoleModel::getName).collect(Collectors.joining(" "));
        this.createdAt = userModel.getCreatedAt();
        this.updateAt = userModel.getUpdateAt();
    }

}
