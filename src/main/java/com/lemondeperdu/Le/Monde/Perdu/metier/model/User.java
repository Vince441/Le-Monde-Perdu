package com.lemondeperdu.Le.Monde.Perdu.metier.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String idUser;
    private String email;
    private String pseudo;
    private String password;
    private String genre;

}
