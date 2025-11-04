package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByPseudo(String pseudo);
}
