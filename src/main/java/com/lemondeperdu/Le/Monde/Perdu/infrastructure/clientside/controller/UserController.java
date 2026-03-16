package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.controller;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.UpdateUserDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.UserCreeDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.UserDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.UserRequestDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper.UserDtoMapper;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.UserUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @RequestBody UserRequestDto userRequestDto) {

        User user = userUseCase.creeUtilisateur(userDtoMapper.toModel(userRequestDto));


        return ResponseEntity.status(HttpStatus.CREATED).body(userDtoMapper.toDtoCree(user));

    }

    @PatchMapping("/{id}/cree-compte")
    public ResponseEntity<UserDto> updateCompteCreer(
            @PathVariable String id,
            @RequestBody UpdateUserDto updateUserDto) {

        // mapstruct -> uniquement les champs modifiables
        User userUpdate = userDtoMapper.toModelUpdate(updateUserDto);

        // On passe l'id directement en paramètre du use case
        User updatedUser = userUseCase.updateCompteCreer(id, userUpdate);

        return ResponseEntity.ok(userDtoMapper.toUserDto(updatedUser));
    }

    @PatchMapping("{id}/updateUtilisateur")
    public ResponseEntity<UserDto> updateUtilisateur(
            @PathVariable String id,
            @RequestBody UserDto userDto) {
        User user = userDtoMapper.toModelUpdateDto(userDto);
        User updateUtilisateur = userUseCase.updateUtilisateur(id, user);
        return ResponseEntity.ok(userDtoMapper.toUserDto(updateUtilisateur));
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable String id) {

        User user = userUseCase.recupererUtilisateur(id);


        return ResponseEntity.ok(userDtoMapper.toUserDto(user));

    }


}
