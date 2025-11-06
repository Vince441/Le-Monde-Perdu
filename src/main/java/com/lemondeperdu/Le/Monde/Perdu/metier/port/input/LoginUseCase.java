package com.lemondeperdu.Le.Monde.Perdu.metier.port.input;


import com.lemondeperdu.Le.Monde.Perdu.metier.model.Token;

public interface LoginUseCase {


    Token login(String email, String password);
}
