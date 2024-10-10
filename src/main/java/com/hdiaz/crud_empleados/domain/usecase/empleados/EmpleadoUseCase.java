package com.hdiaz.crud_empleados.domain.usecase.empleados;

import com.hdiaz.crud_empleados.domain.model.empleados.Empleado;
import com.hdiaz.crud_empleados.domain.model.empleados.gateway.EmpleadoGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmpleadoUseCase {

    private final EmpleadoGateway empleadoGateway;

    public Empleado guardarEmpleado(Empleado empleado){
        return empleadoGateway.guardarEmpleado(empleado);
    }
}
