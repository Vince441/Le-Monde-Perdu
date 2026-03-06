package com.lemondeperdu.Le.Monde.Perdu.metier.port.input;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoCodes;

public interface DinoCodeUseCase {
    DinoCodes postDinosaureParIdDinosaure(DinoCodes model);

    DinoCodes recupererDinosaureParCode(String code);
}
