package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures;

import java.util.List;

public record UtilisateurDinosauresRequestDto(
        Long id,
        String idUser,
        String idDinosaures
) {
}
