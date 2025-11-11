package com.lemondeperdu.Le.Monde.Perdu.metier.service;

import com.lemondeperdu.Le.Monde.Perdu.metier.exception.DinosaureException;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoCodes;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.DinoCodeUseCase;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.DinoCodesPort;

public class DinoCodeService implements DinoCodeUseCase {

    private final DinoCodesPort dinoCodesPort;

    public DinoCodeService(DinoCodesPort dinoCodesPort) {
        this.dinoCodesPort = dinoCodesPort;
    }


    @Override
    public DinoCodes postDinosaureParIdDinosaure(DinoCodes dinoCodes) {
        return dinoCodesPort.postDinoCode(dinoCodes);
    }

    @Override
    public DinoCodes recupererDinosaureParCode(String code) {
        return dinoCodesPort.recupererDinosaureParCode(code).orElseThrow(() -> new DinosaureException("Code non trouvé"));
    }
}
