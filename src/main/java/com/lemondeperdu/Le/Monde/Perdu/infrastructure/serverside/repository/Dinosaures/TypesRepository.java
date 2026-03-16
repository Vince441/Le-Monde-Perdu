package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.TypesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypesRepository extends JpaRepository<TypesEntity, Integer> {
}
