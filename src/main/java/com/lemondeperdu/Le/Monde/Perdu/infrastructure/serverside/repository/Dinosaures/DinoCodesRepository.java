package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.DinoCodesEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface DinoCodesRepository extends JpaRepository<DinoCodesEntity, String> {
    Optional<DinoCodesEntity> findByCode(String code);
}
