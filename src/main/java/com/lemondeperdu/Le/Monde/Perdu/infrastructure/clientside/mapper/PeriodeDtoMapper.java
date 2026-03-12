package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.PeriodesDto;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Periodes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeriodeDtoMapper {

    Periodes toModel(PeriodesDto dto);
    PeriodesDto toDto(Periodes model);
}
