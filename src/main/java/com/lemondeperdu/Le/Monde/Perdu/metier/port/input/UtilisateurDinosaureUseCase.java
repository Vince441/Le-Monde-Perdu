package com.lemondeperdu.Le.Monde.Perdu.metier.port.input;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.UtilisateurDinosaures;

import java.util.List;

public interface UtilisateurDinosaureUseCase {
    List<UtilisateurDinosaures> recupererToutLesDinosauresByIdUser(String idUser);

    UtilisateurDinosaures ajouterDinosaureInUtilisateurDinosaure(String code, String idUser);
}
