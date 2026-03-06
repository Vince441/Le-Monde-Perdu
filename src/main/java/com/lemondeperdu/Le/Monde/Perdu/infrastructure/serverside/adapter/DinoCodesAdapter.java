package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.adapter;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.DinoCodesEntity;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper.DinoCodesEntityMapper;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper.DinosaureEntityMapper;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper.UserEntityMapper;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures.DinoCodesRepository;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures.DinosaureRepository;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.UserRepository;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoCodes;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.DinoCodesPort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DinoCodesAdapter implements DinoCodesPort {

    private final DinoCodesRepository dinoCodesRepository;
    private final DinoCodesEntityMapper dinoCodesEntityMapper;
    private final DinosaureEntityMapper dinosaureEntityMapper;
    private final UserEntityMapper userEntityMapper;
    private final DinosaureRepository dinosaureRepository;
    private final UserRepository userRepository;

    public DinoCodesAdapter(DinoCodesRepository dinoCodesRepository, DinoCodesEntityMapper dinoCodesEntityMapper, DinosaureEntityMapper dinosaureEntityMapper, UserEntityMapper userEntityMapper, DinosaureRepository dinosaureRepository, UserRepository userRepository) {
        this.dinoCodesRepository = dinoCodesRepository;
        this.dinoCodesEntityMapper = dinoCodesEntityMapper;
        this.dinosaureEntityMapper = dinosaureEntityMapper;
        this.userEntityMapper = userEntityMapper;
        this.dinosaureRepository = dinosaureRepository;
        this.userRepository = userRepository;
    }


    public DinoCodes postDinoCode(DinoCodes dinoCodes) {

        Dinosaure dino = dinosaureRepository.findById(dinoCodes.getDinosaure().getId())
                .map(dinosaureEntityMapper::toModel)
                .orElseThrow(() -> new RuntimeException("Dinosaure non trouvé"));


        User user = userRepository.findById(dinoCodes.getUsedBy().getIdUser())
                .map(userEntityMapper::toModel)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));




        dinoCodes.setCode(dinoCodes.getCode());
        dinoCodes.setDinosaure(dino);
        dinoCodes.setUsedBy(user);



        DinoCodesEntity entity = dinoCodesEntityMapper.toEntity(dinoCodes);
        DinoCodesEntity savedEntity = dinoCodesRepository.save(entity);

        return dinoCodesEntityMapper.toModel(savedEntity);
    }

    @Override
    public Optional<DinoCodes> recupererDinosaureParCode(String code) {
        return dinoCodesRepository.findByCode(code).map(dinoCodesEntityMapper::toModel);
    }

}
