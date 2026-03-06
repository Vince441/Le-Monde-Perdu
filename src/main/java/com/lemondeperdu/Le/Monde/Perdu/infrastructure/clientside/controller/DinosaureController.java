package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.controller;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.DinosaureDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.UtilisateurDinosauresRequestDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper.DinosaureDtoMapper;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.UtilisateurDinosaures;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.DinosauresUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/dinosaures")
public class DinosaureController {

    private final DinosauresUseCase dinosauresUseCase;
    private final DinosaureDtoMapper dinosaureDtoMapper;

    public DinosaureController(DinosauresUseCase dinosauresUseCase, DinosaureDtoMapper dinosaureDtoMapper) {
        this.dinosauresUseCase = dinosauresUseCase;
        this.dinosaureDtoMapper = dinosaureDtoMapper;
    }


    @GetMapping("/{id}")
    public ResponseEntity<DinosaureDto> getDino(
            @PathVariable String id){

        Dinosaure dinosaure = dinosauresUseCase.recupererDinosaures(id);

        return ResponseEntity.ok(dinosaureDtoMapper.toDto(dinosaure));


    }



}
