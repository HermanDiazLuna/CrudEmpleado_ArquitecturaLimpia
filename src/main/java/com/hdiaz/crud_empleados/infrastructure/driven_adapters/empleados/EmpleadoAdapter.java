package com.hdiaz.crud_empleados.infrastructure.driven_adapters.empleados;

import com.hdiaz.crud_empleados.domain.model.empleados.Empleado;
import com.hdiaz.crud_empleados.domain.model.empleados.gateway.EmpleadoGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
public class EmpleadoAdapter implements EmpleadoGateway {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        EmpleadoEntity empleadoEntity = empleadoRepository.save(this.getEmpleadoEntity(empleado));
        return this.getEmpleado(empleadoEntity);
    }

    @Override
    public Empleado buscarEmpleadoPorId(Integer id) {
        Optional<EmpleadoEntity> findById = empleadoRepository.findById(id);
        return this.getEmpleado(findById.get());
    }

    @Override
    public List<Empleado> buscarTodos() {
        List<EmpleadoEntity> listaEmpleadosEntity = empleadoRepository.findAll();
        return listaEmpleadosEntity.stream()
                .map(this::getEmpleado)
                .collect(Collectors.toList());
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
