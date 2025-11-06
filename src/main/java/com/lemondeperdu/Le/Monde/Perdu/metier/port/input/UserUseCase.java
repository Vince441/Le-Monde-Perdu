package com.lemondeperdu.Le.Monde.Perdu.metier.port.input;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.UpdateUserDto;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;

public interface UserUseCase {
    User creeUtilisateur(User user);

    User updateUtilisateur(String id, User userUpdate);
}
