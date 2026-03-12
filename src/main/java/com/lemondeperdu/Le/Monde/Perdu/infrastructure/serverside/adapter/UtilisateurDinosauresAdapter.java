package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.adapter;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.DinoCodesEntity;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.DinosaureEntity;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.UserEntity;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.UtilisateurDinosauresEntity;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper.UtilisateurDinosauresEntityMapper;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures.DinoCodesRepository;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures.UtilisateurDinosauresRepository;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.UserRepository;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.UtilisateurDinosaures;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.UtilisateurDinosauresPort;
import com.lemondeperdu.Le.Monde.Perdu.metier.service.UserService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UtilisateurDinosauresAdapter implements UtilisateurDinosauresPort {

    private final UtilisateurDinosauresEntityMapper utilisateurDinosauresEntityMapper;
    private final UtilisateurDinosauresRepository utilisateurDinosauresRepository;
    private final DinoCodesRepository dinoCodesRepository;
    private final UserRepository userRepository;

    public UtilisateurDinosauresAdapter(UtilisateurDinosauresEntityMapper utilisateurDinosauresEntityMapper, UtilisateurDinosauresRepository utilisateurDinosauresRepository, DinoCodesRepository dinoCodesRepository, UserService userService, UserRepository userRepository) {
        this.utilisateurDinosauresEntityMapper = utilisateurDinosauresEntityMapper;
        this.utilisateurDinosauresRepository = utilisateurDinosauresRepository;
        this.dinoCodesRepository = dinoCodesRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<UtilisateurDinosaures> recupererToutLesDinosauresParIdUser(String idUser) {
        return utilisateurDinosauresRepository.findByUser_IdUser(idUser).stream().map(utilisateurDinosauresEntityMapper::toModel).toList();
    }

    @Override
    public UtilisateurDinosaures ajouterDinosaureInUtilisateurDinosaure(String code, String idUser) {

        DinoCodesEntity dinoCode = dinoCodesRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Code invalide"));


        DinosaureEntity dinosaure = dinoCode.getDinosaureEntity();

        UserEntity user = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        UtilisateurDinosauresEntity lien = new UtilisateurDinosauresEntity();
        lien.setUser(user);
        lien.setDinosaures(dinosaure);

        UtilisateurDinosauresEntity saved = utilisateurDinosauresRepository.save(lien);

        return utilisateurDinosauresEntityMapper.toModel(saved);
    }
}
