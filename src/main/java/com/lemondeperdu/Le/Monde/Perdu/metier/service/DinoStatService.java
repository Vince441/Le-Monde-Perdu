package com.lemondeperdu.Le.Monde.Perdu.metier.service;

import com.lemondeperdu.Le.Monde.Perdu.metier.exception.DinoStatException;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoStat;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.DinoStatUseCase;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.DinoStatPort;

public class DinoStatService implements DinoStatUseCase {

    private final DinoStatPort dinoStatPort;

    public DinoStatService(DinoStatPort dinoStatPort) {
        this.dinoStatPort = dinoStatPort;
    }


    @Override
    public DinoStat recupererStatByIdDino(String idDino) {
        return dinoStatPort.recupererStatByIdDino(idDino).orElseThrow(() -> new DinoStatException("Les stats ne sont pas accessible pour le dinosaure" + idDino));

    }
}
