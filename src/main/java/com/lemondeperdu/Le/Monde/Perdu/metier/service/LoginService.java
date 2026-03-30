package com.lemondeperdu.Le.Monde.Perdu.metier.service;

import com.lemondeperdu.Le.Monde.Perdu.metier.exception.UserException;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Token;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.LoginUseCase;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.UserPort;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LoginService implements LoginUseCase {

    private final UserPort userPort;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;


    public LoginService(UserPort userPort, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userPort = userPort;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @Override
    public Token login(String email, String password) {
        User user = userPort.findByEmail(email)
                .orElseThrow(() -> new UserException("Email ou mot de passe incorrect"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UserException("Email ou mot de passe incorrect");
        }

        String jwt = tokenService.generateToken(user.getEmail());

        // Crée le Token domaine (JWT + User) sans le stocker
        return Token.builder()
                .token(jwt)
                .user(user)
                .build();
    }
}
