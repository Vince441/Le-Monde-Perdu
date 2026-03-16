package com.lemondeperdu.Le.Monde.Perdu.metier.port.output;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoStat;


import java.util.Optional;

public interface DinoStatPort {
    Optional <DinoStat> recupererStatByIdDino(String idDino);
}
