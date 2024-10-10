package com.hdiaz.crud_empleados.infrastructure.entry_points.empleados;

import com.hdiaz.crud_empleados.domain.model.empleados.Empleado;
import com.hdiaz.crud_empleados.domain.usecase.empleados.EmpleadoUseCase;
import com.hdiaz.crud_empleados.infrastructure.entry_points.dtos.EmpleadoRequestDTO;
import com.hdiaz.crud_empleados.infrastructure.entry_points.dtos.EmpleadoResponseDTO;
import com.hdiaz.crud_empleados.infrastructure.entry_points.dtos.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoUseCase empleadoUseCase;

    @PostMapping("/guardar-empleado")
    public ResponseEntity<EmpleadoResponseDTO> crearEmpleado(@RequestBody EmpleadoRequestDTO empleadoRequestDTO){
        Empleado empleado = empleadoUseCase.guardarEmpleado(Mapper.empleadoRequestDTOtoEmpleado(empleadoRequestDTO));
        return ResponseEntity.ok(Mapper.empleadoToEmpleadoResponseDTO(empleado));
    }
}