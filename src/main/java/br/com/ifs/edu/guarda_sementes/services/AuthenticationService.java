package br.com.ifs.edu.guarda_sementes.services;

import br.com.ifs.edu.guarda_sementes.configs.security.TokenService;
import br.com.ifs.edu.guarda_sementes.dtos.authentication.AuthenticationDTO;
import br.com.ifs.edu.guarda_sementes.dtos.authentication.GeneratedToken;
import br.com.ifs.edu.guarda_sementes.dtos.authentication.ResponseLoginDTO;
import br.com.ifs.edu.guarda_sementes.repositories.IUserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthenticationService {

    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthenticationService(IUserRepository userRepository, BCryptPasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }


    public ResponseLoginDTO login(AuthenticationDTO authenticationDTO) {

        var user = userRepository.findByEmail(authenticationDTO.email());

        if (user.isEmpty() || !user.get().isLoginCorrect(authenticationDTO, passwordEncoder)) {
            throw new BadCredentialsException("Email or password is incorrect.");
        }

        var generatedToken = tokenService.generateToken(user);

        return new ResponseLoginDTO(generatedToken.token(), generatedToken.expiresIn());
    }
}
