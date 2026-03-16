package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.controller;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.DinoStatsResponseDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper.DinoStatDtoMapper;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoStat;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.DinoStatUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/dino-stat")
public class DinoStatsController {

    private final DinoStatDtoMapper dinostatsDtoMapper;
    private final DinoStatUseCase dinostatsUseCase;


    public DinoStatsController(DinoStatDtoMapper dinostatsDtoMapper, DinoStatUseCase dinostatsUseCase) {
        this.dinostatsDtoMapper = dinostatsDtoMapper;
        this.dinostatsUseCase = dinostatsUseCase;
    }

    @GetMapping("/{idDino}")
    public ResponseEntity<DinoStatsResponseDto> getStatByIdDino(@PathVariable String idDino) {

        DinoStat dinoStat = dinostatsUseCase.recupererStatByIdDino(idDino);

        return ResponseEntity.ok(dinostatsDtoMapper.toDto(dinoStat));

    }

}
