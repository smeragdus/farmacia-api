package com.farmacia.controller;

import com.farmacia.dto.ProveedorDTO;
import com.farmacia.mapper.ProveedorMapper;
import com.farmacia.service.ProveedorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorService service;

    public ProveedorController(ProveedorService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProveedorDTO> listar() {
        return service.listar().stream().map(ProveedorMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProveedorDTO obtener(@PathVariable Long id) {
        return ProveedorMapper.toDTO(service.obtenerPorId(id));
    }

    @PostMapping
    public ProveedorDTO guardar(@Valid @RequestBody ProveedorDTO dto) {
        return ProveedorMapper.toDTO(service.guardar(ProveedorMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public ProveedorDTO actualizar(@PathVariable Long id, @Valid @RequestBody ProveedorDTO dto) {
        return ProveedorMapper.toDTO(service.actualizar(id, ProveedorMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
