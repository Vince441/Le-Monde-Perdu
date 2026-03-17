package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.controller;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.DinoRequestDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.DinosaureDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.PeriodesDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.TypesDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper.DinosaureDtoMapper;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper.PeriodeDtoMapper;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper.TypesDtoMapper;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Dinosaure;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Periodes;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Types;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.DinosauresUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/dinosaures")
public class DinosaureController {

    private final DinosauresUseCase dinosauresUseCase;
    private final DinosaureDtoMapper dinosaureDtoMapper;
    private final TypesDtoMapper typesDtoMapper;
    private final PeriodeDtoMapper periodeDtoMapper;

    public DinosaureController(DinosauresUseCase dinosauresUseCase, DinosaureDtoMapper dinosaureDtoMapper, TypesDtoMapper typesDtoMapper, PeriodeDtoMapper periodeDtoMapper) {
        this.dinosauresUseCase = dinosauresUseCase;
        this.dinosaureDtoMapper = dinosaureDtoMapper;
        this.typesDtoMapper = typesDtoMapper;
        this.periodeDtoMapper = periodeDtoMapper;
    }


    @GetMapping("/{id}")
    public ResponseEntity<DinosaureDto> getDino(
            @PathVariable String id) {
        Dinosaure dinosaure = dinosauresUseCase.recupererDinosaures(id);
        return ResponseEntity.ok(dinosaureDtoMapper.toDto(dinosaure));
    }

    @PostMapping()
    public ResponseEntity<DinosaureDto> postDino(
            @RequestBody DinoRequestDto dinoRequestDto) {
        Dinosaure dinosaure = dinosauresUseCase.postDinosaure(dinosaureDtoMapper.toModel(dinoRequestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(dinosaureDtoMapper.toDto(dinosaure));
    }

    @GetMapping("/type-dinosaure")
    public ResponseEntity<List<TypesDto>> getType() {
        List<Types> types = dinosauresUseCase.getTypesDinosaures();

        return ResponseEntity.ok(typesDtoMapper.toDto(types));
    }


    @GetMapping("/periode-dinosaure")
    public ResponseEntity<List<PeriodesDto>> getPeriode() {
        List<Periodes> periodes = dinosauresUseCase.getPeriodesDinosaures();
        return ResponseEntity.ok(periodeDtoMapper.toDto(periodes));
    }


}
