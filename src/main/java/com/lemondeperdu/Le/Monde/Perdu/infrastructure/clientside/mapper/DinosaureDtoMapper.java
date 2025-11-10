package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.DinosaureDto;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Periodes;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Types;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DinosaureDtoMapper {


    Dinosaure toModel(DinosaureDto dinosaureDto);

    DinosaureDto toDto(Dinosaure dinosaure);

}
