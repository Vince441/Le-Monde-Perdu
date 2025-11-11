package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.DinosaureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DinosaureRepository extends JpaRepository<DinosaureEntity, String > {
}
