package com.lemondeperdu.Le.Monde.Perdu.metier.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Types;

@Data
@Builder
public class Dinosaure {

    String id;

    Types types;

    Periodes periodes;

    String tailles;

    String poids;

    String description;

    String url;








}
