package br.com.ifs.edu.guarda_sementes.controllers;

import br.com.ifs.edu.guarda_sementes.dtos.authentication.AuthenticationDTO;
import br.com.ifs.edu.guarda_sementes.dtos.authentication.ResponseLoginDTO;
import br.com.ifs.edu.guarda_sementes.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseLoginDTO login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        return this.authenticationService.login(authenticationDTO);
    }
}
