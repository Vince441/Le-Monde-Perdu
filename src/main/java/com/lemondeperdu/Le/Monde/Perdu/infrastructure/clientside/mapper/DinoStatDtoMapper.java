package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.DinoStatsRequestDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.DinoStatsResponseDto;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoStat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DinoStatDtoMapper {


    DinoStat toModel(DinoStatsRequestDto dto);

    @Mapping(source = "faiblesse", target = "idFaiblesse")
    @Mapping(source = "resistance", target = "idResistance")
    @Mapping(source = "force", target = "idForce")
    DinoStatsResponseDto toDto(DinoStat model);

}
