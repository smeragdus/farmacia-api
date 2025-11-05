package com.farmacia.controller;

import com.farmacia.dto.DetalleVentaDTO;
import com.farmacia.mapper.DetalleVentaMapper;
import com.farmacia.service.DetalleVentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/detalles-venta")
public class DetalleVentaController {

    private final DetalleVentaService service;

    public DetalleVentaController(DetalleVentaService service) {
        this.service = service;
    }

    @GetMapping
    public List<DetalleVentaDTO> listar() {
        return service.listar().stream().map(DetalleVentaMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DetalleVentaDTO obtener(@PathVariable Long id) {
        return DetalleVentaMapper.toDTO(service.obtenerPorId(id));
    }

    @PostMapping
    public DetalleVentaDTO guardar(@Valid @RequestBody DetalleVentaDTO dto) {
        return DetalleVentaMapper.toDTO(service.guardar(DetalleVentaMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public DetalleVentaDTO actualizar(@PathVariable Long id, @Valid @RequestBody DetalleVentaDTO dto) {
        return DetalleVentaMapper.toDTO(service.actualizar(id, DetalleVentaMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
