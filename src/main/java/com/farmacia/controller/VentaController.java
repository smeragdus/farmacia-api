package com.farmacia.controller;

import com.farmacia.dto.VentaDTO;
import com.farmacia.mapper.VentaMapper;
import com.farmacia.service.VentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService service;

    public VentaController(VentaService service) {
        this.service = service;
    }

    @GetMapping
    public List<VentaDTO> listar() {
        return service.listar().stream().map(VentaMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VentaDTO obtener(@PathVariable Long id) {
        return VentaMapper.toDTO(service.obtenerPorId(id));
    }

    @PostMapping
    public VentaDTO guardar(@Valid @RequestBody VentaDTO dto) {
        return VentaMapper.toDTO(service.guardar(VentaMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public VentaDTO actualizar(@PathVariable Long id, @Valid @RequestBody VentaDTO dto) {
        return VentaMapper.toDTO(service.actualizar(id, VentaMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
