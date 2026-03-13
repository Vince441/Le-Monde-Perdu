package com.lemondeperdu.Le.Monde.Perdu.infrastructure.configuration;

import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.*;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.*;
import com.lemondeperdu.Le.Monde.Perdu.metier.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class GeneralConfiguration {

    @Bean
    public UserUseCase userUseCase(UserPort userPort, PasswordEncoder passwordEncoder){
        return new UserService(userPort, passwordEncoder);
    }

    @Bean
    public LoginUseCase loginUseCase(UserPort userPort, PasswordEncoder passwordEncoder){
        return new LoginService(userPort, passwordEncoder);
    }

    @Bean
    public DinosauresUseCase dinosauresUseCase(DinosaurePort dinosaurePort){
        return new DinosauresService(dinosaurePort);
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
    DinoStatUseCase dinoStatUseCase(DinoStatPort dinoStatPort){
        return new DinoStatService(dinoStatPort);
    }
}
