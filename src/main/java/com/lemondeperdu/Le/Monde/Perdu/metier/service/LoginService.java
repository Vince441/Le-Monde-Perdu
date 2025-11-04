package com.lemondeperdu.Le.Monde.Perdu.metier.service;

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
    public String login(String pseudo, String password) {
        User user = userPort.findByPseudo(pseudo)
                .orElseThrow(() -> new UserException("Pseudo ou mot de passe incorrect"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UserException("Pseudo ou mot de passe incorrect");
        }

        // Générer le token JWT
        return TokenService.generateToken(user.getPseudo());
    }
}
