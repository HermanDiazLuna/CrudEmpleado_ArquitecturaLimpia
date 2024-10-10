package com.hdiaz.crud_empleados.infrastructure.entry_points.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoResponseDTO {

    private Integer id;
    private String cedula;
    private String nombre;
}
