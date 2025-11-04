package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.UserEntity;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntity toEntity(User user);

    User toModel (UserEntity userEntity);

}
