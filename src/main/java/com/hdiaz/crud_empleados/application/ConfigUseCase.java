package com.hdiaz.crud_empleados.application;

import com.hdiaz.crud_empleados.domain.model.empleados.gateway.EmpleadoGateway;
import com.hdiaz.crud_empleados.domain.usecase.empleados.EmpleadoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigUseCase {

    @Bean
    public EmpleadoUseCase empleadoUseCase(EmpleadoGateway empleadoGateway){
        return new EmpleadoUseCase(empleadoGateway);
    }

}
