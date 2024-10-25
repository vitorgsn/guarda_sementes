package br.com.ifs.edu.guarda_sementes.configs.security;

import br.com.ifs.edu.guarda_sementes.dtos.authentication.GeneratedToken;
import br.com.ifs.edu.guarda_sementes.models.UserModel;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class TokenService {

    private final JwtEncoder jwtEncoder;

    public TokenService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public GeneratedToken generateToken(Optional<UserModel> user) {
        try {
            var now = Instant.now();
            var expiresIn = 300L;

            if (user.isEmpty()) {
                throw new RuntimeException("Error while generating token");
            }

            var claims = JwtClaimsSet.builder()
                    .issuer("guardasementes")
                    .subject(user.get().getId().toString())
                    .issuedAt(now)
                    .expiresAt(now.plusSeconds(expiresIn))
                    .build();

            return new GeneratedToken(jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue(), expiresIn);

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
    }
}
