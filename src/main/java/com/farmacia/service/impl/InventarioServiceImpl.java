package com.farmacia.service.impl;

import com.farmacia.entity.Inventario;
import com.farmacia.exception.RecursoNoEncontradoException;
import com.farmacia.repository.InventarioRepository;
import com.farmacia.service.InventarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository repository;

    public InventarioServiceImpl(InventarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Inventario> listar() {
        return repository.findAll();
    }

    @Override
    public Inventario obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Inventario con ID " + id + " no encontrado"));

    }

    @Override
    public Inventario guardar(Inventario inventario) {
        return repository.save(inventario);
    }

    @Override
    public Inventario actualizar(Long id, Inventario inventario) {
        inventario.setIdInventario(id);
        return repository.save(inventario);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
