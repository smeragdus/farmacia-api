package com.farmacia.service.impl;

import com.farmacia.entity.Productos;
import com.farmacia.exception.RecursoNoEncontradoException;
import com.farmacia.repository.ProductosRepository;
import com.farmacia.service.ProductosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosService {

    private final ProductosRepository repository;

    public ProductosServiceImpl(ProductosRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Productos> listar() {
        return repository.findAll();
    }

    @Override
    public Productos obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto con ID " + id + " no encontrado"));

    }

    @Override
    public Productos guardar(Productos producto) {
        return repository.save(producto);
    }

    @Override
    public Productos actualizar(Long id, Productos producto) {
        producto.setIdProducto(id);
        return repository.save(producto);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
