package com.lemondeperdu.Le.Monde.Perdu.metier.service;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.TokenDto;
import com.lemondeperdu.Le.Monde.Perdu.metier.exception.UserException;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.LoginUseCase;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.UserPort;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LoginService implements LoginUseCase {

    private final UserPort userPort;
    private final PasswordEncoder passwordEncoder;

    public LoginService(UserPort userPort, PasswordEncoder passwordEncoder) {
        this.userPort = userPort;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public TokenDto login(String email, String password) {
        User user = userPort.findByEmail(email)
                .orElseThrow(() -> new UserException("L'email ou mot de passe incorrect"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UserException("L'email ou mot de passe incorrect");
        }

        String token = TokenService.generateToken(user.getEmail());

        // Générer le token JWT
        return new TokenDto(token, user.getEmail(), user.getIdUser());
    }
}
