package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.Role;

public record UserDto(
        String idUser,
        String email,
        String pseudo,
        String genre,
        Role role
) {
}
