package com.lemondeperdu.Le.Monde.Perdu.metier.port.input;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Periodes;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Types;

import java.util.List;


public interface DinosauresUseCase {

    Dinosaure recupererDinosaures(String id);


    Dinosaure postDinosaure(Dinosaure dinosaure);


    List<Types> getTypesDinosaures();

    List<Periodes> getPeriodesDinosaures();

    List<Types> getTypeDinosaure();

    List<Periodes> getPeriodeDinosaure();
}
