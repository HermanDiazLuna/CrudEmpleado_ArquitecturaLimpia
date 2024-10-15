package com.hdiaz.crud_empleados.domain.usecase.empleados;

import com.hdiaz.crud_empleados.domain.model.empleados.Empleado;
import com.hdiaz.crud_empleados.domain.model.empleados.gateway.EmpleadoGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmpleadoUseCase {

    private final EmpleadoGateway empleadoGateway;

    public Empleado guardarEmpleado(Empleado empleado){
        return empleadoGateway.guardarEmpleado(empleado);
    }

    public Empleado buscarEmpleadoPorId(Integer id){
        return empleadoGateway.buscarEmpleadoPorId(id);
    }

    public List<Empleado> buscarTodosLosEmpleados(){
        return empleadoGateway.buscarTodos();
    }
}
