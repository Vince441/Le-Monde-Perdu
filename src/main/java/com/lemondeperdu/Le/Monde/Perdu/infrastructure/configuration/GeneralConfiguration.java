package com.lemondeperdu.Le.Monde.Perdu.infrastructure.configuration;

import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.DinoCodeUseCase;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.DinosauresUseCase;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.LoginUseCase;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.input.UserUseCase;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.DinoCodesPort;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.DinosaurePort;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.UserPort;
import com.lemondeperdu.Le.Monde.Perdu.metier.service.DinoCodeService;
import com.lemondeperdu.Le.Monde.Perdu.metier.service.DinosauresService;
import com.lemondeperdu.Le.Monde.Perdu.metier.service.LoginService;
import com.lemondeperdu.Le.Monde.Perdu.metier.service.UserService;
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
}
