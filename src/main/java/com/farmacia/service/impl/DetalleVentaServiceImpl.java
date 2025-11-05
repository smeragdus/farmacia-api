package com.farmacia.service.impl;

import com.farmacia.entity.DetalleVenta;
import com.farmacia.exception.RecursoNoEncontradoException;
import com.farmacia.repository.DetalleVentaRepository;
import com.farmacia.service.DetalleVentaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

    private final DetalleVentaRepository repository;

    public DetalleVentaServiceImpl(DetalleVentaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DetalleVenta> listar() {
        return repository.findAll();
    }

    @Override
    public DetalleVenta obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Detalle de venta con ID " + id + " no encontrado"));

    }

    @Override
    public DetalleVenta guardar(DetalleVenta detalle) {
        return repository.save(detalle);
    }

    @Override
    public DetalleVenta actualizar(Long id, DetalleVenta detalle) {
        detalle.setIdDetalleVenta(id);
        return repository.save(detalle);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
