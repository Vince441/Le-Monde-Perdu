package com.lemondeperdu.Le.Monde.Perdu.metier.port.output;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Periodes;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Types;

import java.util.List;
import java.util.Optional;

public interface DinosaurePort {


    Optional<Dinosaure> recupererDinosaure(String id);


    Dinosaure postDinosaure(Dinosaure dinosaure);


    List<Periodes> getPeriodes();

    List<Types> getTypes();
}
