package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures;

import java.time.LocalDateTime;

public record DinoCodeResponseDto(
        String code,
        String idDinosaure,
        String idUser,
        LocalDateTime usedAt
) {
}
