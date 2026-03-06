package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.adapter;



import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper.DinosaureEntityMapper;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures.DinosaureRepository;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.DinosaurePort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DinosaureAdapter implements DinosaurePort {

   private final DinosaureRepository dinosaureRepository;
   private final DinosaureEntityMapper dinosaureEntityMapper;

    public DinosaureAdapter(DinosaureRepository dinosaureRepository, DinosaureEntityMapper dinosaureEntityMapper) {
        this.dinosaureRepository = dinosaureRepository;
        this.dinosaureEntityMapper = dinosaureEntityMapper;
    }


    @Override
    public Optional<Dinosaure> recupererDinosaure(String id) {
 return dinosaureRepository.findById(id).map(dinosaureEntityMapper::toModel);
    }


}
