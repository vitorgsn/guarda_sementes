package br.com.ifs.edu.guarda_sementes.services;

import br.com.ifs.edu.guarda_sementes.configs.security.TokenService;
import br.com.ifs.edu.guarda_sementes.dtos.authentication.AuthenticationDTO;
import br.com.ifs.edu.guarda_sementes.dtos.authentication.ResponseLoginDTO;
import br.com.ifs.edu.guarda_sementes.models.UserModel;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationService (AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public ResponseLoginDTO login (AuthenticationDTO authenticationDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.password());
        var authentication = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel) authentication.getPrincipal());

        return new ResponseLoginDTO(token);
    }

}
