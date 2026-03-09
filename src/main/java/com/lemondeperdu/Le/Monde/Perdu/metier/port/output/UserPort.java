package com.lemondeperdu.Le.Monde.Perdu.metier.port.output;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;

import java.util.Optional;


public interface UserPort {

    User creeUser(User user);

    Optional<User> findByEmail(String email);


    User updateUser(String id, User userUpdate);

    Optional<User> recupererUtilisateur(String id);
}
