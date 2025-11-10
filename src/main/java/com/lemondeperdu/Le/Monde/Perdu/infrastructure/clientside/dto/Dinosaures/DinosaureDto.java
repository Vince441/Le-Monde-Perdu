package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures;

public record DinosaureDto(

        String id,

        TypesDto typesDto,

        PeriodesDto periodesDto,

        String tailles,

        String poids,

        String description,

        String url

) {
}
