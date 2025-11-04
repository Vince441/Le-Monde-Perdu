package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.UserCreeDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.UserRequestDto;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    UserRequestDto toDto(User user);

    User toModel (UserRequestDto userRequestDto);

    UserCreeDto toDtoCree(User user);

    User toModelCree(UserCreeDto userCreeDto);


}
