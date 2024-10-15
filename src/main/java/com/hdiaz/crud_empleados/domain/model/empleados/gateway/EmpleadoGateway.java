package com.hdiaz.crud_empleados.domain.model.empleados.gateway;

import com.hdiaz.crud_empleados.domain.model.empleados.Empleado;

public interface EmpleadoGateway {

    Empleado guardarEmpleado(Empleado empleado);

    Empleado buscarEmpleadoPorId(Integer id);
}
