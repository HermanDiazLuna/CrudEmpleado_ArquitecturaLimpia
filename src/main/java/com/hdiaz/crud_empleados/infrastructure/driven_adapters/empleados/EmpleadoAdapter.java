package com.hdiaz.crud_empleados.infrastructure.driven_adapters.empleados;

import com.hdiaz.crud_empleados.domain.model.empleados.Empleado;
import com.hdiaz.crud_empleados.domain.model.empleados.gateway.EmpleadoGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class EmpleadoAdapter implements EmpleadoGateway {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        EmpleadoEntity empleadoEntity = empleadoRepository.save(this.getEmpleadoEntity(empleado));
        return this.getEmpleado(empleadoEntity);
    }

    private EmpleadoEntity getEmpleadoEntity(Empleado empleado){
        return EmpleadoEntity.builder()
                .cedula(empleado.getCedula())
                .nombre(empleado.getNombre())
                .build();
    }

    private Empleado getEmpleado(EmpleadoEntity empleadoEntity){
        return Empleado.builder()
                .id(empleadoEntity.getId())
                .cedula(empleadoEntity.getCedula())
                .nombre(empleadoEntity.getNombre())
                .build();
    }
}
