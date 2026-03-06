package com.lemondeperdu.Le.Monde.Perdu.metier.service;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.UtilisateurDinosaures;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.UtilisateurDinosaureUseCase;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.UtilisateurDinosauresPort;

import java.util.List;

public class UtilisateurDinosaureService implements UtilisateurDinosaureUseCase {

    private final UtilisateurDinosauresPort utilisateurDinosauresPort;

    public UtilisateurDinosaureService(UtilisateurDinosauresPort utilisateurDinosauresPort) {
        this.utilisateurDinosauresPort = utilisateurDinosauresPort;
    }

    @Override
    public List<UtilisateurDinosaures> recupererToutLesDinosauresByIdUser(String idUser) {
        return utilisateurDinosauresPort.recupererToutLesDinosauresParIdUser(idUser);
    }
}
