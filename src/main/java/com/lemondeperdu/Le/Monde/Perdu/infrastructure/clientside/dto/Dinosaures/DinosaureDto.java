package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures;

public record DinosaureDto(
        String id,
        PeriodesDto periodes,
        TypesDto types,
        String taille,
        String poid,
        String description,
        String url
) {}
