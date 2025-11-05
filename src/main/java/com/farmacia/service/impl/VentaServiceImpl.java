package com.farmacia.service.impl;

import com.farmacia.entity.Venta;
import com.farmacia.exception.RecursoNoEncontradoException;
import com.farmacia.exception.RecursoNoEncontradoException;
import com.farmacia.repository.VentaRepository;
import com.farmacia.service.VentaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository repository;

    public VentaServiceImpl(VentaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Venta> listar() {
        return repository.findAll();
    }

    @Override
    public Venta obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Venta con ID " + id + " no encontrado"));

    }

    @Override
    public Venta guardar(Venta venta) {
        return repository.save(venta);
    }

    @Override
    public Venta actualizar(Long id, Venta venta) {
        venta.setIdVenta(id);
        return repository.save(venta);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
