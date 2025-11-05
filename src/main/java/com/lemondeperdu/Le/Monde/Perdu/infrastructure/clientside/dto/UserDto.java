package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto;

public record UserDto(
        String id,
        String email,
        String pseudo,
        String genre
) {}
