package com.lemondeperdu.Le.Monde.Perdu.metier.port.input;

import com.lemondeperdu.Le.Monde.Perdu.metier.exception.UserException;

public interface LoginUseCase {

    String login(String pseudo, String password) throws UserException;


}
