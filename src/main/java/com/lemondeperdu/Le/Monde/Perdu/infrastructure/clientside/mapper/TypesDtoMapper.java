package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.TypesDto;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Types;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypesDtoMapper {
    Types toModel(TypesDto dto);
    TypesDto toDto(Types model);
}
