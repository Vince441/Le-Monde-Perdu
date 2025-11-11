package com.lemondeperdu.Le.Monde.Perdu.metier.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dinosaure {

    String id;

    Types types;

    Periodes periodes;

    String taille;

    String poid;

    String description;

    String url;


}
