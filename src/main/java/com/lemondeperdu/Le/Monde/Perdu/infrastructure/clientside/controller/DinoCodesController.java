package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.controller;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.DinoCodeRequestDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.Dinosaures.DinoCodeResponseDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper.DinoCodeDtoMapper;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoCodes;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.DinoCodeUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/dinosaures")
public class DinoCodesController {

    private final DinoCodeUseCase dinoCodeUseCase;
    private final DinoCodeDtoMapper dinoCodesDtoMapper;

    public DinoCodesController(DinoCodeUseCase dinoCodeUseCase, DinoCodeDtoMapper dinoCodesDtoMapper) {
        this.dinoCodeUseCase = dinoCodeUseCase;
        this.dinoCodesDtoMapper = dinoCodesDtoMapper;
    }


    @PostMapping("/dinoCodes")
    public ResponseEntity<DinoCodeResponseDto> postDinosaureParIdDinosaure( @RequestBody DinoCodeRequestDto dinoCodeRequestDto
    ){
        DinoCodes dinoCodes = dinoCodeUseCase.postDinosaureParIdDinosaure(dinoCodesDtoMapper.toModel(dinoCodeRequestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(dinoCodesDtoMapper.toDto(dinoCodes));

    }

    @GetMapping("/dinoCodes/{code}")
    public ResponseEntity<DinoCodeResponseDto> getDinoParCode(
            @PathVariable String code){

        DinoCodes dinoCodes = dinoCodeUseCase.recupererDinosaureParCode(code);

        return ResponseEntity.ok(dinoCodesDtoMapper.toDto(dinoCodes));


    }



}
