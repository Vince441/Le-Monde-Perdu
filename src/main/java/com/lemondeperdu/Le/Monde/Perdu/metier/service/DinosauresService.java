package com.lemondeperdu.Le.Monde.Perdu.metier.service;

import com.lemondeperdu.Le.Monde.Perdu.metier.exception.DinosaureException;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.DinosauresUseCase;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.DinosaurePort;

public class DinosauresService implements DinosauresUseCase {

    private final DinosaurePort dinosaurePort;

    public DinosauresService(DinosaurePort dinosaurePort) {
        this.dinosaurePort = dinosaurePort;
    }


    @Override
    public Dinosaure recupererDinosaures(String id) {
        return dinosaurePort.recupererDinosaure(id).orElseThrow(() -> new DinosaureException("Dinosaure non trouvé"));

    }
}
