package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.DinosaureEntity;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;

public interface DinosaureEntityMapper {

    DinosaureEntity toEntity(Dinosaure dinosaure);

    Dinosaure toModel (DinosaureEntity dinosaureEntity);

}
