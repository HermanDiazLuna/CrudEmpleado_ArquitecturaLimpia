package com.hdiaz.crud_empleados.infrastructure.entry_points.empleados.dtos;

import com.hdiaz.crud_empleados.domain.model.empleados.Empleado;

import java.util.ArrayList;
import java.util.List;

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

    public static List<EmpleadoResponseDTO> empleadosToEmpleadosRequestDTO(List<Empleado> empleadoList){
        List<EmpleadoResponseDTO> empleadoResponseDTOList = new ArrayList<>();
        for(Empleado empleado: empleadoList){
            empleadoResponseDTOList.add(empleadoToEmpleadoResponseDTO(empleado));
        }
        return empleadoResponseDTOList;

    }

}
