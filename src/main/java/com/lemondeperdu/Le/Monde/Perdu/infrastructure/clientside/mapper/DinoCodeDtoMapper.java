package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.DinoCodeRequestDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.DinoCodeResponseDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.DinosaureEntity;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoCodes;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DinoCodeDtoMapper {

    @Mapping(target="dinosaure", expression = "java(toDinosaure(dinoCodeRequestDto.idDinosaure()))")
    @Mapping(target="usedBy", expression ="java(toUsedBy(dinoCodeRequestDto.idUser()))")
    DinoCodes toModel (DinoCodeRequestDto dinoCodeRequestDto);

    @Mapping(target="idDinosaure", source="dinosaure.id")
    @Mapping(target="idUser", source="usedBy.idUser")
    DinoCodeResponseDto toDto (DinoCodes dinoCodes);


    default Dinosaure toDinosaure(String id){
        return Dinosaure.builder().id(id).build();
    }

    default User toUsedBy(String id){
        return User.builder().idUser(id).build();
    }
}