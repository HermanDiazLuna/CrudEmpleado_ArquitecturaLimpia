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

import java.util.ArrayList;
import java.util.List;

class EmpleadoUseCaseTest {

    @Mock
    private EmpleadoGateway empleadoGateway;

    @InjectMocks
    private EmpleadoUseCase empleadoUseCase;

    private Empleado empleado;

    private Empleado empleadoDB;

    private List<Empleado> listaEmpleados;

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

        listaEmpleados = new ArrayList<>();

        listaEmpleados.add(empleadoDB);
    }

    @Test
    public void guardarEmpleadoTest(){

        Mockito.when(empleadoGateway.guardarEmpleado(empleado)).thenReturn(empleadoDB);
        Empleado empleadoGuardado = empleadoUseCase.guardarEmpleado(empleado);
        Assertions.assertEquals(1,empleadoGuardado.getId());

    }

    @Test
    public void buscarEmpleadoPorIdTest(){

        Integer empleadoId = 1;
        Mockito.when(empleadoGateway.buscarEmpleadoPorId(empleadoId)).thenReturn(empleadoDB);

        Empleado resultado = empleadoUseCase.buscarEmpleadoPorId(empleadoId);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(empleadoId, resultado.getId());
        Assertions.assertEquals("12345", resultado.getCedula());
        Assertions.assertEquals("Orlando Perez", resultado.getNombre());

        Mockito.verify(empleadoGateway, Mockito.times(1)).buscarEmpleadoPorId(empleadoId);
    }

    @Test
    public void buscarTodosLosEmpleadosTest() {

        Mockito.when(empleadoGateway.buscarTodos()).thenReturn(listaEmpleados);

        List<Empleado> resultado = empleadoUseCase.buscarTodosLosEmpleados();

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals("12345", resultado.get(0).getCedula());
        Assertions.assertEquals("Orlando Perez", resultado.get(0).getNombre());

        Mockito.verify(empleadoGateway, Mockito.times(1)).buscarTodos();
    }

    @Test
    public void actualizarEmpleadoTest() {

        Integer empleadoId = 1;
        Empleado empleadoActualizado = Empleado.builder()
                .nombre("Orlando Gomez")
                .cedula("12345")
                .build();

        Mockito.when(empleadoGateway.buscarEmpleadoPorId(empleadoId)).thenReturn(empleadoDB);
        Mockito.when(empleadoGateway.actualizarEmpleado(Mockito.any(Empleado.class)))
                .thenReturn(empleadoActualizado);

        Empleado resultado = empleadoUseCase.actualizarEmpleado(empleadoActualizado, empleadoId);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals("Orlando Gomez", resultado.getNombre());
        Assertions.assertEquals("12345", resultado.getCedula());

        Mockito.verify(empleadoGateway, Mockito.times(1)).buscarEmpleadoPorId(empleadoId);
        Mockito.verify(empleadoGateway, Mockito.times(1)).actualizarEmpleado(Mockito.any(Empleado.class));
    }
}