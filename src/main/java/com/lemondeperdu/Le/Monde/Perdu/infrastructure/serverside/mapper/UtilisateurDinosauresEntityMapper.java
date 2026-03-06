package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.UtilisateurDinosauresEntity;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.UtilisateurDinosaures;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UtilisateurDinosauresEntityMapper {

    @Mapping(source="dinosaures.id", target = "idDinosaures")
    @Mapping(source="user.idUser", target = "idUser")
    UtilisateurDinosaures toModel(UtilisateurDinosauresEntity utilisateurDinosauresEntity);

    @Mapping(target="dinosaures.id", source = "idDinosaures")
    @Mapping(target="user.idUser", source = "idUser")
    UtilisateurDinosauresEntity toEntity(UtilisateurDinosaures utilisateurDinosaures);

}
