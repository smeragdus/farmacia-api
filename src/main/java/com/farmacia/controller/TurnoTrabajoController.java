package com.farmacia.controller;

import com.farmacia.dto.TurnoTrabajoDTO;
import com.farmacia.mapper.TurnoTrabajoMapper;
import com.farmacia.service.TurnoTrabajoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/turnos")
public class TurnoTrabajoController {

    private final TurnoTrabajoService service;

    public TurnoTrabajoController(TurnoTrabajoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TurnoTrabajoDTO> listar() {
        return service.listar().stream().map(TurnoTrabajoMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TurnoTrabajoDTO obtener(@PathVariable Long id) {
        return TurnoTrabajoMapper.toDTO(service.obtenerPorId(id));
    }

    @PostMapping
    public TurnoTrabajoDTO guardar(@Valid @RequestBody TurnoTrabajoDTO dto) {
        return TurnoTrabajoMapper.toDTO(service.guardar(TurnoTrabajoMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public TurnoTrabajoDTO actualizar(@PathVariable Long id, @Valid @RequestBody TurnoTrabajoDTO dto) {
        return TurnoTrabajoMapper.toDTO(service.actualizar(id, TurnoTrabajoMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
