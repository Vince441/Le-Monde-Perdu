package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.TokenDto;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Token;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TokenDtoMapper {

    @Mapping(target = "userDto.idUser", source = "user.idUser")
    @Mapping(target = "userDto.pseudo", source = "user.pseudo")
    @Mapping(target = "userDto.email", source = "user.email")
    TokenDto toDto (Token token);

    Token toModel (TokenDto tokenDto);

}
