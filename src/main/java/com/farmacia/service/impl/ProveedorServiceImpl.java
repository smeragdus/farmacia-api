package com.farmacia.service.impl;

import com.farmacia.entity.Proveedor;
import com.farmacia.exception.RecursoNoEncontradoException;
import com.farmacia.repository.ProveedorRepository;
import com.farmacia.service.ProveedorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository repository;

    public ProveedorServiceImpl(ProveedorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Proveedor> listar() {
        return repository.findAll();
    }

    @Override
    public Proveedor obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Proveedor con ID " + id + " no encontrado"));

    }

    @Override
    public Proveedor guardar(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    @Override
    public Proveedor actualizar(Long id, Proveedor proveedor) {
        proveedor.setIdProveedor(id);
        return repository.save(proveedor);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
