package com.farmacia.service.impl;

import com.farmacia.entity.Receta;
import com.farmacia.exception.RecursoNoEncontradoException;
import com.farmacia.repository.RecetaRepository;
import com.farmacia.service.RecetaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaServiceImpl implements RecetaService {

    private final RecetaRepository repository;

    public RecetaServiceImpl(RecetaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Receta> listar() {
        return repository.findAll();
    }

    @Override
    public Receta obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Receta con ID " + id + " no encontrado"));

    }

    @Override
    public Receta guardar(Receta receta) {
        return repository.save(receta);
    }

    @Override
    public Receta actualizar(Long id, Receta receta) {
        receta.setIdReceta(id);
        return repository.save(receta);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
