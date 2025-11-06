package com.lemondeperdu.Le.Monde.Perdu.metier.model;


import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Token {


    private String token;
    private User user;


}
