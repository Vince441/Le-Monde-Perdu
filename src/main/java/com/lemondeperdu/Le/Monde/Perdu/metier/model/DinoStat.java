package com.lemondeperdu.Le.Monde.Perdu.metier.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DinoStat {
    String id;

    Dinosaure dinosaure;

    Integer niveau;

    Integer attaque;

    Integer resistancePhysique;

    Integer vie;

    Integer chanceCritique;

    Types faiblesse;

    Types resistance;

    Types force;

}
