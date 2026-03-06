package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.adapter;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper.UtilisateurDinosauresEntityMapper;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.Dinosaures.UtilisateurDinosauresRepository;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.UtilisateurDinosaures;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.UtilisateurDinosauresPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UtilisateurDinosauresAdapter implements UtilisateurDinosauresPort {

    private final UtilisateurDinosauresEntityMapper utilisateurDinosauresEntityMapper;
    private final UtilisateurDinosauresRepository utilisateurDinosauresRepository;

    public UtilisateurDinosauresAdapter(UtilisateurDinosauresEntityMapper utilisateurDinosauresEntityMapper, UtilisateurDinosauresRepository utilisateurDinosauresRepository) {
        this.utilisateurDinosauresEntityMapper = utilisateurDinosauresEntityMapper;
        this.utilisateurDinosauresRepository = utilisateurDinosauresRepository;
    }

    @Override
    public List<UtilisateurDinosaures> recupererToutLesDinosauresParIdUser(String idUser) {
        return utilisateurDinosauresRepository.findByUser_IdUser(idUser).stream().map(utilisateurDinosauresEntityMapper::toModel).toList();
    }
}
