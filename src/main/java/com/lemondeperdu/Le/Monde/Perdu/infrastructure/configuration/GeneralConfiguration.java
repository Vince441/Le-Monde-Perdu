package com.lemondeperdu.Le.Monde.Perdu.infrastructure.configuration;

import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.*;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.*;
import com.lemondeperdu.Le.Monde.Perdu.metier.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class GeneralConfiguration {

    @Bean
    public UserUseCase userUseCase(UserPort userPort, PasswordEncoder passwordEncoder){
        return new UserService(userPort, passwordEncoder);
    }

    @Bean
    public TokenService tokenService(JwtProperties jwtProperties) {
        return new TokenService(jwtProperties);
    }

    @Bean
    public LoginUseCase loginUseCase(UserPort userPort, PasswordEncoder passwordEncoder, TokenService tokenService){
        return new LoginService(userPort, passwordEncoder, tokenService);
    }

    @Bean
    public DinosauresUseCase dinosauresUseCase(DinosaurePort dinosaurePort, CodeGeneratorDinoConfiguration codeGeneratorDinoConfiguration){
        return new DinosauresService(dinosaurePort, codeGeneratorDinoConfiguration);
    }

    @Bean
    DinoCodeUseCase dinoCodeUseCase(DinoCodesPort dinoCodesPort, CodeGeneratorDinoConfiguration codeGeneratorDinoConfiguration){
        return new DinoCodeService(dinoCodesPort, codeGeneratorDinoConfiguration);
    }


    @Bean
    UtilisateurDinosaureUseCase utilisateurDinosaureUseCase(UtilisateurDinosauresPort utilisateurDinosauresPort){
        return new UtilisateurDinosaureService(utilisateurDinosauresPort);
    }

    @Bean
    public UserDetailsService userDetailsService(UserPort userPort) {
        return new UserDetailsServiceImpl(userPort);
    }

    @Bean
    DinoStatUseCase dinoStatUseCase(DinoStatPort dinoStatPort){
        return new DinoStatService(dinoStatPort);
    }
}
