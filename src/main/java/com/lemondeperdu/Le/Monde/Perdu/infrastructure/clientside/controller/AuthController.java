package com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.controller;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.LoginRequestDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.dto.TokenDto;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.clientside.mapper.TokenDtoMapper;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.Token;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.LoginUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginUseCase loginUseCase;
    private final TokenDtoMapper tokenDtoMapper;

    public AuthController(LoginUseCase loginUseCase, TokenDtoMapper tokenDtoMapper) {
        this.loginUseCase = loginUseCase;
        this.tokenDtoMapper = tokenDtoMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequestDto request) {
        Token token = loginUseCase.login(request.email(), request.password());
        TokenDto responseDto = tokenDtoMapper.toDto(token); // Mapping domaine -> DTO
        return ResponseEntity.ok(responseDto);
    }


}
