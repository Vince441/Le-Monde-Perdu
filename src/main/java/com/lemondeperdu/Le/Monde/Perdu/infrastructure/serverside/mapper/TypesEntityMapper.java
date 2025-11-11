package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.TypesEntity;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Types;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypesEntityMapper {

    Types toModel(TypesEntity typesEntity);
    TypesEntity toEntity(Types types);

}
