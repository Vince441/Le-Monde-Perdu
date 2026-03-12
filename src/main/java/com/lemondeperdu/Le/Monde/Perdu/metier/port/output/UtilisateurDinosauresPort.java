package com.lemondeperdu.Le.Monde.Perdu.metier.port.output;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.UtilisateurDinosaures;

import java.util.List;

public interface UtilisateurDinosauresPort {
    List<UtilisateurDinosaures> recupererToutLesDinosauresParIdUser(String idUser);

    UtilisateurDinosaures ajouterDinosaureInUtilisateurDinosaure(String code, String idUser);
}
