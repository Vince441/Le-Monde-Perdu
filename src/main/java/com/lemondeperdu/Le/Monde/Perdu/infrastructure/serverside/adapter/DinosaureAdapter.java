package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.adapter;


import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.DinosaureEntity;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.PeriodesEntity;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.TypesEntity;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper.DinosaureEntityMapper;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures.DinosaureRepository;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures.PeriodesRepository;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures.TypesRepository;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.DinosaurePort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DinosaureAdapter implements DinosaurePort {

    private final DinosaureRepository dinosaureRepository;
    private final DinosaureEntityMapper dinosaureEntityMapper;
    private final TypesRepository typesRepository;
    private final PeriodesRepository periodesRepository;

    public DinosaureAdapter(DinosaureRepository dinosaureRepository, DinosaureEntityMapper dinosaureEntityMapper, TypesRepository typesRepository, PeriodesRepository periodesRepository) {
        this.dinosaureRepository = dinosaureRepository;
        this.dinosaureEntityMapper = dinosaureEntityMapper;
        this.typesRepository = typesRepository;
        this.periodesRepository = periodesRepository;
    }


    @Override
    public Optional<Dinosaure> recupererDinosaure(String id) {
        return dinosaureRepository.findById(id).map(dinosaureEntityMapper::toModel);
    }

    @Override
    public Dinosaure postDinosaure(Dinosaure dinosaure) {

        DinosaureEntity dinosaureEntity = dinosaureEntityMapper.toEntity(dinosaure);

        TypesEntity typesEntity = typesRepository.getReferenceById(dinosaure.getTypes().getId());
        PeriodesEntity periodesEntity = periodesRepository.getReferenceById(dinosaure.getPeriodes().getId());

        dinosaureEntity.setPeriodesEntity(periodesEntity);
        dinosaureEntity.setTypesEntity(typesEntity);

        DinosaureEntity dinosaureSaved = dinosaureRepository.save(dinosaureEntity);
        return dinosaureEntityMapper.toModel(dinosaureSaved);
    }


}
