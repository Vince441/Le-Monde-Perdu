package com.lemondeperdu.Le.Monde.Perdu.metier.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DinoCodes {

    private String code;

    private Dinosaure dinosaure;

    private LocalDateTime usedAt;

}
