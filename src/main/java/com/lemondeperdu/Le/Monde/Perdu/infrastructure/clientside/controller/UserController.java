package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.controller;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.UserCreeDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.UserRequestDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper.UserDtoMapper;
import lombok.extern.slf4j.Slf4j;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.UserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/utilisateur")
public class UserController {

    private final UserUseCase userUseCase;
    private final UserDtoMapper userDtoMapper;


    public UserController(UserUseCase userUseCase, UserDtoMapper userDtoMapper) {
        this.userUseCase = userUseCase;
        this.userDtoMapper = userDtoMapper;
    }


    @PostMapping()
    public ResponseEntity<UserCreeDto> createUser(
            @RequestBody UserRequestDto userRequestDto){

                User user = userUseCase.creeUtilisateur(userDtoMapper.toModel(userRequestDto));

                return ResponseEntity.status(HttpStatus.CREATED).body(userDtoMapper.toDtoCree(user));

    }



}
