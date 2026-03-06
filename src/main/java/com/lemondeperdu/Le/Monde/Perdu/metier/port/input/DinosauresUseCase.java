package com.lemondeperdu.Le.Monde.Perdu.metier.port.input;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;

import java.util.List;


public interface DinosauresUseCase {

    Dinosaure recupererDinosaures(String id);

}
