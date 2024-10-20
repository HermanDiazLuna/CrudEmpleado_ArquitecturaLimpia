package com.hdiaz.crud_empleados.application;

import com.hdiaz.crud_empleados.domain.model.auth.gateway.AuthGateway;
import com.hdiaz.crud_empleados.domain.model.empleados.gateway.EmpleadoGateway;
import com.hdiaz.crud_empleados.domain.usecase.auth.AuthUseCase;
import com.hdiaz.crud_empleados.domain.usecase.empleados.EmpleadoUseCase;
import com.hdiaz.crud_empleados.infrastructure.security.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConfigUseCase {

    @Bean
    public EmpleadoUseCase empleadoUseCase(EmpleadoGateway empleadoGateway){
        return new EmpleadoUseCase(empleadoGateway);
    }

    @Bean
    public AuthUseCase authUseCase(AuthGateway authGateway, PasswordEncoder passwordEncoder, JwtService jwtService){
        return new AuthUseCase(authGateway,passwordEncoder,jwtService);
    }

}
