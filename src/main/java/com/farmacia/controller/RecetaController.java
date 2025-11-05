package com.farmacia.controller;

import com.farmacia.dto.RecetaDTO;
import com.farmacia.mapper.RecetaMapper;
import com.farmacia.service.RecetaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recetas")
public class RecetaController {

    private final RecetaService service;

    public RecetaController(RecetaService service) {
        this.service = service;
    }

    @GetMapping
    public List<RecetaDTO> listar() {
        return service.listar().stream().map(RecetaMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RecetaDTO obtener(@PathVariable Long id) {
        return RecetaMapper.toDTO(service.obtenerPorId(id));
    }

    @PostMapping
    public RecetaDTO guardar(@Valid @RequestBody RecetaDTO dto) {
        return RecetaMapper.toDTO(service.guardar(RecetaMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public RecetaDTO actualizar(@PathVariable Long id, @Valid @RequestBody RecetaDTO dto) {
        return RecetaMapper.toDTO(service.actualizar(id, RecetaMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
