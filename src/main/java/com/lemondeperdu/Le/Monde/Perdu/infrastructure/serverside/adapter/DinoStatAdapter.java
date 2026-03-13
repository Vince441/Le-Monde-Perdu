package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.adapter;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.DinoStatEntity;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper.DinoStatEntityMapper;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures.DinoStatRepository;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoStat;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.DinoStatPort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DinoStatAdapter implements DinoStatPort {

    private final DinoStatRepository dinoStatRepository;
    private final DinoStatEntityMapper dinoStatEntityMapper;

    public DinoStatAdapter(DinoStatRepository dinoStatRepository, DinoStatEntityMapper dinoStatEntityMapper) {
        this.dinoStatRepository = dinoStatRepository;
        this.dinoStatEntityMapper = dinoStatEntityMapper;
    }

    @Override
    public Optional<DinoStat> recupererStatByIdDino(String idDino) {
        Optional<DinoStatEntity> entityOpt = dinoStatRepository.findByDinosaure_Id(idDino);

        entityOpt.ifPresent(e -> System.out.println("Entity chanceCritique: " + e.getChanceCritique()));

        Optional<DinoStat> modelOpt = entityOpt.map(dinoStatEntityMapper::toModel);

        modelOpt.ifPresent(m -> System.out.println("Model chanceCritique: " + m.getChanceCritique()));

        return modelOpt;
    }
}
