package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.PeriodesEntity;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.TypesEntity;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Periodes;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Types;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeriodeEntityMapper {

    Periodes toModel(PeriodesEntity periodesEntity);
    PeriodesEntity toEntity(Periodes periodes);
}
