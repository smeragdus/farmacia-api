package com.farmacia.controller;

import com.farmacia.dto.ProductosDTO;
import com.farmacia.mapper.ProductosMapper;
import com.farmacia.service.ProductosService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {

    private final ProductosService service;

    public ProductosController(ProductosService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductosDTO> listar() {
        return service.listar().stream().map(ProductosMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductosDTO obtener(@PathVariable Long id) {
        return ProductosMapper.toDTO(service.obtenerPorId(id));
    }

    @PostMapping
    public ProductosDTO guardar(@Valid @RequestBody ProductosDTO dto) {
        return ProductosMapper.toDTO(service.guardar(ProductosMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public ProductosDTO actualizar(@PathVariable Long id, @Valid @RequestBody ProductosDTO dto) {
        return ProductosMapper.toDTO(service.actualizar(id, ProductosMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
