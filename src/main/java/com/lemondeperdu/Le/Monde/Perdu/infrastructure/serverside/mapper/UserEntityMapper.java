package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.UserEntity;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    @Mapping(target = "idUser", source = "idUser")
    @Mapping(target = "role", source = "role")
    User toModel(UserEntity entity);

    @Mapping(target = "idUser", source = "idUser")
    @Mapping(target = "role", source = "role")
    UserEntity toEntity(User user);
}
