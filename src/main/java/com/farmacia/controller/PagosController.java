package com.farmacia.controller;

import com.farmacia.dto.PagosDTO;
import com.farmacia.mapper.PagosMapper;
import com.farmacia.service.PagosService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pagos")
public class PagosController {

    private final PagosService service;

    public PagosController(PagosService service) {
        this.service = service;
    }

    @GetMapping
    public List<PagosDTO> listar() {
        return service.listar().stream().map(PagosMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PagosDTO obtener(@PathVariable Long id) {
        return PagosMapper.toDTO(service.obtenerPorId(id));
    }

    @PostMapping
    public PagosDTO guardar(@Valid @RequestBody PagosDTO dto) {
        return PagosMapper.toDTO(service.guardar(PagosMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public PagosDTO actualizar(@PathVariable Long id, @Valid @RequestBody PagosDTO dto) {
        return PagosMapper.toDTO(service.actualizar(id, PagosMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
