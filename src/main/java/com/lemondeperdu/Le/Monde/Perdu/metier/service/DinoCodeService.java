package com.lemondeperdu.Le.Monde.Perdu.metier.service;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.configuration.CodeGeneratorDinoConfiguration;
import com.lemondeperdu.Le.Monde.Perdu.metier.exception.DinosaureException;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoCodes;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.DinoCodeUseCase;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.DinoCodesPort;

public class DinoCodeService implements DinoCodeUseCase {

    private final DinoCodesPort dinoCodesPort;
    private final CodeGeneratorDinoConfiguration codeGeneratorDinoConfiguration;

    public DinoCodeService(DinoCodesPort dinoCodesPort, CodeGeneratorDinoConfiguration codeGeneratorDinoConfiguration) {
        this.dinoCodesPort = dinoCodesPort;
        this.codeGeneratorDinoConfiguration = codeGeneratorDinoConfiguration;
    }


    @Override
    public DinoCodes postDinosaureParIdDinosaure(DinoCodes dinoCodes) {
        dinoCodes.setCode(codeGeneratorDinoConfiguration.generateCode(dinoCodes.getCode()));
        dinoCodes = dinoCodesPort.postDinoCode(dinoCodes);
        return dinoCodes;
    }

    @Override
    public DinoCodes recupererDinosaureParCode(String code) {
        return dinoCodesPort.recupererDinosaureParCode(code).orElseThrow(() -> new DinosaureException("Code non trouvé"));
    }
}
