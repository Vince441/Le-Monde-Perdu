package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper;


import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.DinosaureEntity;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface DinosaureEntityMapper {

    @Mapping(target = "types", source = "typesEntity")
    @Mapping(target = "periodes", source = "periodesEntity")
    Dinosaure toModel(DinosaureEntity dinosaureEntity);


    DinosaureEntity toEntity(Dinosaure dinosaure);


}


