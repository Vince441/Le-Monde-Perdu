package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.controller;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.UtilisateurDinosaureResponseDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.UtilisateurDinosauresRequestDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper.UtilisateurDinosaureDtoMapper;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.UtilisateurDinosaures;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.UtilisateurDinosaureUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/utilisateur-dinosaures")
public class UtilisateurDinosaureController {

private final UtilisateurDinosaureDtoMapper utilisateurDinosaureDtoMapper;
private final UtilisateurDinosaureUseCase utilisateurDinosaureUseCase;

    public UtilisateurDinosaureController(UtilisateurDinosaureDtoMapper utilisateurDinosaureDtoMapper, UtilisateurDinosaureUseCase utilisateurDinosaureUseCase) {
        this.utilisateurDinosaureDtoMapper = utilisateurDinosaureDtoMapper;
        this.utilisateurDinosaureUseCase = utilisateurDinosaureUseCase;
    }

    @GetMapping("utilisateur/{idUser}")
    public ResponseEntity<List<UtilisateurDinosaureResponseDto>> getAllDinoByUser(
            @PathVariable String idUser){

        List<UtilisateurDinosaures> dinosaureList = utilisateurDinosaureUseCase.recupererToutLesDinosauresByIdUser(idUser);

        List<UtilisateurDinosaureResponseDto> utilisateurDinosaureResponseDtos = utilisateurDinosaureDtoMapper.toDtoList(dinosaureList);

        return ResponseEntity.ok(utilisateurDinosaureResponseDtos);

    }

    @PostMapping()
    public ResponseEntity<UtilisateurDinosaureResponseDto> createUtilisateurDinosauresWithCode(
             @RequestParam String code, String idUser ){
        UtilisateurDinosaures utilisateurDinosaures = utilisateurDinosaureUseCase.ajouterDinosaureInUtilisateurDinosaure(code, idUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurDinosaureDtoMapper.toDto(utilisateurDinosaures));
    }
}
