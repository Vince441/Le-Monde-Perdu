package com.lemondeperdu.Le.Monde.Perdu.metier.port.input;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.TokenDto;
import com.lemondeperdu.Le.Monde.Perdu.metier.exception.UserException;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;

import java.util.Optional;

public interface LoginUseCase {


    TokenDto login(String email, String password);
}
