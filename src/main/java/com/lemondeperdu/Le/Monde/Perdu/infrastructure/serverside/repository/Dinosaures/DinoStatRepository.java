package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.DinoStatEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface DinoStatRepository extends JpaRepository<DinoStatEntity, Integer> {
    Optional<DinoStatEntity> findByDinosaure_Id(String idDino);


}
