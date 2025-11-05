package com.farmacia.controller;

import com.farmacia.dto.RolesDTO;
import com.farmacia.mapper.RolesMapper;
import com.farmacia.service.RolesService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    private final RolesService service;

    public RolesController(RolesService service) {
        this.service = service;
    }

    @GetMapping
    public List<RolesDTO> listar() {
        return service.listar().stream().map(RolesMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RolesDTO obtener(@PathVariable Long id) {
        return RolesMapper.toDTO(service.obtenerPorId(id));
    }

    @PostMapping
    public RolesDTO guardar(@Valid @RequestBody RolesDTO dto) {
        return RolesMapper.toDTO(service.guardar(RolesMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public RolesDTO actualizar(@PathVariable Long id, @Valid @RequestBody RolesDTO dto) {
        return RolesMapper.toDTO(service.actualizar(id, RolesMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
