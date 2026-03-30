package com.lemondeperdu.Le.Monde.Perdu.metier.service;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.configuration.CodeGeneratorDinoConfiguration;
import com.lemondeperdu.Le.Monde.Perdu.metier.exception.DinosaureException;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Periodes;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Types;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.DinosauresUseCase;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.DinosaurePort;

import java.util.List;

public class DinosauresService implements DinosauresUseCase {

    private final DinosaurePort dinosaurePort;
    private final CodeGeneratorDinoConfiguration codeGeneratorDinoConfiguration;

    public DinosauresService(DinosaurePort dinosaurePort, CodeGeneratorDinoConfiguration codeGeneratorDinoConfiguration) {
        this.dinosaurePort = dinosaurePort;
        this.codeGeneratorDinoConfiguration = codeGeneratorDinoConfiguration;
    }


    @Override
    public Dinosaure recupererDinosaures(String id) {
        return dinosaurePort.recupererDinosaure(id).orElseThrow(() -> new DinosaureException("Dinosaure non trouvé"));

    }

    @Override
    public Dinosaure postDinosaure(Dinosaure dinosaure) {
        dinosaure.setCode(codeGeneratorDinoConfiguration.generateCode(dinosaure.getCode()));
        return dinosaurePort.postDinosaure(dinosaure);
    }


    @Override
    public List<Types> getTypesDinosaures() {
        return dinosaurePort.getTypes();
    }

    @Override
    public List<Periodes> getPeriodesDinosaures() {
        return dinosaurePort.getPeriodes();
    }

    @Override
    public List<Types> getTypeDinosaure() {
        return dinosaurePort.getTypes();
    }

    @Override
    public List<Periodes> getPeriodeDinosaure() {
        return dinosaurePort.getPeriodes();
    }


}
