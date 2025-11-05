package com.farmacia.controller;

import com.farmacia.dto.ClienteDTO;
import com.farmacia.mapper.ClienteMapper;
import com.farmacia.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClienteDTO> listar() {
        return service.listar().stream().map(ClienteMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClienteDTO obtener(@PathVariable Long id) {
        return ClienteMapper.toDTO(service.obtenerPorId(id));
    }

    @PostMapping
    public ClienteDTO guardar(@Valid @RequestBody ClienteDTO dto) {
        return ClienteMapper.toDTO(service.guardar(ClienteMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public ClienteDTO actualizar(@PathVariable Long id, @Valid @RequestBody ClienteDTO dto) {
        return ClienteMapper.toDTO(service.actualizar(id, ClienteMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
