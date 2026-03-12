package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.UtilisateurDinosauresEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UtilisateurDinosauresRepository extends JpaRepository<UtilisateurDinosauresEntity, Long> {
    List<UtilisateurDinosauresEntity> findByUser_IdUser(String idUser);

}
