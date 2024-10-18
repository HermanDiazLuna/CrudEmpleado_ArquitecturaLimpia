package com.hdiaz.crud_empleados.infrastructure.entry_points.empleados;

import com.hdiaz.crud_empleados.domain.model.empleados.Empleado;
import com.hdiaz.crud_empleados.domain.usecase.empleados.EmpleadoUseCase;
import com.hdiaz.crud_empleados.infrastructure.entry_points.dtos.EmpleadoRequestDTO;
import com.hdiaz.crud_empleados.infrastructure.entry_points.dtos.EmpleadoResponseDTO;
import com.hdiaz.crud_empleados.infrastructure.entry_points.dtos.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<EmpleadoResponseDTO> buscarPorIdEmpleado(@PathVariable("id") Integer id){
        Empleado empleado = empleadoUseCase.buscarEmpleadoPorId(id);
        return ResponseEntity.ok().body(Mapper.empleadoToEmpleadoResponseDTO(empleado));
    }

    @GetMapping("buscar-todos")
    public ResponseEntity<List<EmpleadoResponseDTO>> buscarTodosLosEmpleados() {
        List<Empleado> empleadoList = empleadoUseCase.buscarTodosLosEmpleados();
        return ResponseEntity.ok().body(Mapper.empleadosToEmpleadosRequestDTO(empleadoList));
    }

    @PutMapping("/actualizar-empleado/{id}")
    public ResponseEntity<EmpleadoResponseDTO> actualizarEmpleado(@RequestBody EmpleadoRequestDTO empleadoRequestDTO, @PathVariable Integer id){
        Empleado empleadoActualizado = empleadoUseCase.actualizarEmpleado(Mapper.empleadoRequestDTOtoEmpleado(empleadoRequestDTO), id);
        return ResponseEntity.ok().body(Mapper.empleadoToEmpleadoResponseDTO(empleadoActualizado));
    }
}
