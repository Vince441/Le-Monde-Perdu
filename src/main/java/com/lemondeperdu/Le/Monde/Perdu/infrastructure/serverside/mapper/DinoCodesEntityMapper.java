package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.DinoCodesEntity;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoCodes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DinoCodesEntityMapper {

    @Mapping(target="dinosaureEntity", source="dinosaure")
    @Mapping(target="userEntity", source="usedBy")
    DinoCodesEntity toEntity (DinoCodes dinoCodes);


    @Mapping(target="dinosaure", source="dinosaureEntity")
    @Mapping(target="usedBy", source="userEntity")
    DinoCodes toModel(DinoCodesEntity dinoCodesEntity);

}
