package br.com.ifs.edu.guarda_sementes.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CreateUserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public CreateUserDTO() {

    }

    public CreateUserDTO(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

}
