package com.lemondeperdu.Le.Monde.Perdu.metier.port.input;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;



public interface DinosauresUseCase {

    Dinosaure recupererDinosaures(String id);
}
