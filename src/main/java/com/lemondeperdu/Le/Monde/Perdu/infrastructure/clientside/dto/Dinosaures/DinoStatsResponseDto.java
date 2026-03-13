package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures;

public record DinoStatsResponseDto(
        int niveau,
        int attaque,
        int resistancePhysique,
        int vie,
        int chanceCritique,
        TypesDto idFaiblesse,
        TypesDto idResistance,
        TypesDto idForce

) {
}
