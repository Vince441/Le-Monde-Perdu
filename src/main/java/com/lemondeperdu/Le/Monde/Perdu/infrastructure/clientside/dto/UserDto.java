package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto;

public record UserDto(
        String idUser,
        String email,
        String pseudo,
        String genre
) {}
