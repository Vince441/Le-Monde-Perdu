package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.PeriodesDto;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Periodes;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeriodeDtoMapper {

    Periodes toModel(PeriodesDto dto);

    PeriodesDto toDto(Periodes model);

    List<Periodes> toModel(List<PeriodesDto> dto);

    List<PeriodesDto> toDto(List<Periodes> model);
}
