package com.hdiaz.crud_empleados.infrastructure.driven_adapters.empleados;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {
}
