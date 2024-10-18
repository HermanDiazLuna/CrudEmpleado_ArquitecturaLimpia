package com.hdiaz.crud_empleados.domain.model.empleados.gateway;

import com.hdiaz.crud_empleados.domain.model.empleados.Empleado;

import java.util.List;

public interface EmpleadoGateway {

    Empleado guardarEmpleado(Empleado empleado);

    Empleado buscarEmpleadoPorId(Integer id);

    List<Empleado> buscarTodos();

    Empleado actualizarEmpleado(Empleado empleado);
}
