package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.UtilisateurDinosaureResponseDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.UtilisateurDinosauresRequestDto;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.UtilisateurDinosaures;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UtilisateurDinosaureDtoMapper {

    UtilisateurDinosaures toModel (UtilisateurDinosauresRequestDto utilisateurDinosauresRequestDto);

    UtilisateurDinosaureResponseDto toDto (UtilisateurDinosaures utilisateurDinosaures);

    List<UtilisateurDinosaures> toModelList(List<UtilisateurDinosauresRequestDto> utilisateurDinosauresRequestDto);

    @Mapping(source = "user.idUser", target = "idUser")
    @Mapping(source = "dinosaureDto", target ="dinosaure")
    List<UtilisateurDinosaureResponseDto> toDtoList (List<UtilisateurDinosaures> utilisateurDinosaures);

}
