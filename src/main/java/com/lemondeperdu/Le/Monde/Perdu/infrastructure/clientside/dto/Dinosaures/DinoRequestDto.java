package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures;

public record DinoRequestDto(
        String nom,
        Integer periodes,
        Integer types,
        String taille,
        String poid,
        String description,
        String url,
        String code
) {
}
