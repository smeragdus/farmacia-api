package com.farmacia.controller;

import com.farmacia.dto.EmpleadosDTO;
import com.farmacia.mapper.EmpleadosMapper;
import com.farmacia.service.EmpleadosService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadosController {

    private final EmpleadosService service;

    public EmpleadosController(EmpleadosService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmpleadosDTO> listar() {
        return service.listar().stream().map(EmpleadosMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EmpleadosDTO obtener(@PathVariable Long id) {
        return EmpleadosMapper.toDTO(service.obtenerPorId(id));
    }

    @PostMapping
    public EmpleadosDTO guardar(@Valid @RequestBody EmpleadosDTO dto) {
        return EmpleadosMapper.toDTO(service.guardar(EmpleadosMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public EmpleadosDTO actualizar(@PathVariable Long id, @Valid @RequestBody EmpleadosDTO dto) {
        return EmpleadosMapper.toDTO(service.actualizar(id, EmpleadosMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
