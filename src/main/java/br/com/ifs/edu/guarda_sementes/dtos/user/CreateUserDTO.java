package br.com.ifs.edu.guarda_sementes.dtos.user;

import br.com.ifs.edu.guarda_sementes.enums.UserRole;
import lombok.Data;

@Data
public class CreateUserDTO {

    private String name;
    private String email;
    private String password;
    private UserRole role;

    public CreateUserDTO() {

    }

    public CreateUserDTO(String name, String email, String password, UserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
