package com.lemondeperdu.Le.Monde.Perdu.metier.port.input;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoStat;

public interface DinoStatUseCase {
    DinoStat recupererStatByIdDino(String idDino);
}
