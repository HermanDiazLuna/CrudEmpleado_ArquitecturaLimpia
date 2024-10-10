package com.hdiaz.crud_empleados.domain.model.empleados;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

    private Integer id;
    private String cedula;
    private String nombre;

}
