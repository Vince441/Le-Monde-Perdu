package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.DinoStatEntity;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoStat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DinoStatEntityMapper {

    DinoStatEntity toEntity(DinoStat dinoStat);

    @Mapping(source = "faiblesse", target = "faiblesse")
    @Mapping(source = "resistance", target = "resistance")
    @Mapping(source = "force", target = "force")
    DinoStat toModel(DinoStatEntity dinoStat);



}
