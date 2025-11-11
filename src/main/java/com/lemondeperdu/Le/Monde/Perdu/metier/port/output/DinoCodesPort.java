package com.lemondeperdu.Le.Monde.Perdu.metier.port.output;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoCodes;
import java.util.Optional;

public interface DinoCodesPort {
    DinoCodes postDinoCode(DinoCodes dinoCodes);

    Optional <DinoCodes> recupererDinosaureParCode(String code);
}
