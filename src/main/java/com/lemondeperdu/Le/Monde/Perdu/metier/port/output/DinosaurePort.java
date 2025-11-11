package com.lemondeperdu.Le.Monde.Perdu.metier.port.output;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;

import java.util.Optional;

public interface DinosaurePort {


    Optional<Dinosaure> recupererDinosaure(String id);
}
