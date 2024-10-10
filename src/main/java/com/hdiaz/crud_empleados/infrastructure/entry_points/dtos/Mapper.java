package com.hdiaz.crud_empleados.infrastructure.entry_points.dtos;

import com.hdiaz.crud_empleados.domain.model.empleados.Empleado;

public class Mapper {

    public static Empleado empleadoRequestDTOtoEmpleado(EmpleadoRequestDTO empleadoRequestDTO){
        return Empleado.builder()
                .cedula(empleadoRequestDTO.getCedula())
                .nombre(empleadoRequestDTO.getNombre())
                .build();
    }

    public static EmpleadoResponseDTO empleadoToEmpleadoResponseDTO(Empleado empleado){
        return EmpleadoResponseDTO.builder()
                .id(empleado.getId())
                .cedula(empleado.getCedula())
                .nombre(empleado.getNombre())
                .build();
    }
}
