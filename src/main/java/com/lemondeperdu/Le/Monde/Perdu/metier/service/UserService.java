package com.lemondeperdu.Le.Monde.Perdu.metier.service;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.UpdateUserDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.configuration.ValidatorConfig;
import com.lemondeperdu.Le.Monde.Perdu.metier.exception.UserException;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.UserUseCase;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.UserPort;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService implements UserUseCase {

    private final UserPort userPort;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserPort userPort, PasswordEncoder passwordEncoder) {
        this.userPort = userPort;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User creeUtilisateur(User user) {
        verificationUser(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userPort.creeUser(user);
        return user;
    }

    @Override
    @Transactional
    public User updateUtilisateur(String id, User userUpdate) {


        return userPort.updateUser(id, userUpdate);
    }




    private void verificationUser(User user) {

        // Vérification pseudo
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new UserException("L'email n'est pas renseigné.");
        }
        if (!ValidatorConfig.isSafeEmail(user.getEmail())) {
            throw new UserException(
                    "L'email' n'est pas valide : "
            );
        }

        // Vérification mot de passe
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new UserException("Le mot de passe n'est pas renseigné.");
        }
        if (!ValidatorConfig.isValidPassword(user.getPassword())) {
            throw new UserException(
                    "Le mot de passe n'est pas valide : " +
                            "il doit contenir 8 à 20 caractères, " +
                            "au moins une majuscule, une minuscule, un chiffre et un caractère spécial."
            );
        }
    }
}
