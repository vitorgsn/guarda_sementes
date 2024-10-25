package br.com.ifs.edu.guarda_sementes.controllers;

import br.com.ifs.edu.guarda_sementes.dtos.authentication.AuthenticationDTO;
import br.com.ifs.edu.guarda_sementes.dtos.authentication.ResponseLoginDTO;
import br.com.ifs.edu.guarda_sementes.dtos.user.CreateUserDTO;
import br.com.ifs.edu.guarda_sementes.dtos.user.ResponseUserDTO;
import br.com.ifs.edu.guarda_sementes.services.AuthenticationService;
import br.com.ifs.edu.guarda_sementes.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    public AuthenticationController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseUserDTO register(@RequestBody @Validated CreateUserDTO userDTO) {
        return new ResponseUserDTO(this.userService.create(userDTO));
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseLoginDTO login(@RequestBody @Validated AuthenticationDTO authenticationDTO) {
        return this.authenticationService.login(authenticationDTO);
    }
}
