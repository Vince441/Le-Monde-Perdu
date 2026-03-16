package com.lemondeperdu.Le.Monde.Perdu.metier.port.input;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.DinosaureDto;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;

import java.util.List;


public interface DinosauresUseCase {

    Dinosaure recupererDinosaures(String id);


    Dinosaure postDinosaure(Dinosaure dinosaure);
}
