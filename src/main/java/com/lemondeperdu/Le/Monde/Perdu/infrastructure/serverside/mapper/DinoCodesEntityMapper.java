package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.DinoCodesEntity;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoCodes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DinosaureEntityMapper.class})
public interface DinoCodesEntityMapper {

    @Mapping(target="dinosaureEntity", source="dinosaure")
    DinoCodesEntity toEntity (DinoCodes dinoCodes);


    @Mapping(target="dinosaure", source="dinosaureEntity")
    DinoCodes toModel(DinoCodesEntity dinoCodesEntity);

}
