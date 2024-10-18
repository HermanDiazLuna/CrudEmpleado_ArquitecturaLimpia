package com.hdiaz.crud_empleados.domain.usecase.empleados;

import com.hdiaz.crud_empleados.domain.model.empleados.Empleado;
import com.hdiaz.crud_empleados.domain.model.empleados.gateway.EmpleadoGateway;
import com.hdiaz.crud_empleados.infrastructure.driven_adapters.empleados.EmpleadoEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

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

    public Empleado actualizarEmpleado(Empleado empleado, Integer id){
        Empleado empleadoPorId = empleadoGateway.buscarEmpleadoPorId(id);
        empleadoPorId.setNombre(empleado.getNombre());
        return empleadoGateway.actualizarEmpleado(empleadoPorId);
    }
}
