package com.hdiaz.crud_empleados.domain.usecase.empleados;

import com.hdiaz.crud_empleados.domain.model.empleados.Empleado;
import com.hdiaz.crud_empleados.domain.model.empleados.gateway.EmpleadoGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class EmpleadoUseCaseTest {

    @Mock
    private EmpleadoGateway empleadoGateway;

    @InjectMocks
    private EmpleadoUseCase empleadoUseCase;

    private Empleado empleado;

    private Empleado empleadoDB;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        empleado = Empleado.builder()
                .cedula("12345")
                .nombre("Orlando Perez")
                .build();

        empleadoDB = Empleado.builder()
                .id(1)
                .cedula("12345")
                .nombre("Orlando Perez")
                .build();
    }

    @Test
    public void guardarEmpleadoTest(){

        Mockito.when(empleadoGateway.guardarEmpleado(empleado)).thenReturn(empleadoDB);
        Empleado empleadoGuardado = empleadoUseCase.guardarEmpleado(empleado);
        Assertions.assertEquals(1,empleadoGuardado.getId());

    }
}