package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.DinosaureDto;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")

public interface DinosaureDtoMapper {

    @Mapping(target = "types", source = "types")
    @Mapping(target = "periodes", source = "periodes")
    Dinosaure toModel(DinosaureDto dinosaureDto);

    @Mapping(target = "types", source = "types")
    @Mapping(target = "periodes", source = "periodes")
    DinosaureDto toDto(Dinosaure dinosaure);


}