package br.com.ifs.edu.guarda_sementes.dtos.user;

import lombok.Data;

@Data
public class CreateUserDTO {

    private String name;
    private String email;
    private String password;

    public CreateUserDTO() {

    }

    public CreateUserDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
