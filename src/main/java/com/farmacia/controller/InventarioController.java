package com.farmacia.controller;

import com.farmacia.dto.InventarioDTO;
import com.farmacia.mapper.InventarioMapper;
import com.farmacia.service.InventarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private final InventarioService service;

    public InventarioController(InventarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<InventarioDTO> listar() {
        return service.listar().stream().map(InventarioMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public InventarioDTO obtener(@PathVariable Long id) {
        return InventarioMapper.toDTO(service.obtenerPorId(id));
    }

    @PostMapping
    public InventarioDTO guardar(@Valid @RequestBody InventarioDTO dto) {
        return InventarioMapper.toDTO(service.guardar(InventarioMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public InventarioDTO actualizar(@PathVariable Long id, @Valid @RequestBody InventarioDTO dto) {
        return InventarioMapper.toDTO(service.actualizar(id, InventarioMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
