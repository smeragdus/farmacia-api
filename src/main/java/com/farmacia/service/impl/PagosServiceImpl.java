package com.farmacia.service.impl;

import com.farmacia.entity.Pagos;
import com.farmacia.exception.RecursoNoEncontradoException;
import com.farmacia.repository.PagosRepository;
import com.farmacia.service.PagosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagosServiceImpl implements PagosService {

    private final PagosRepository repository;

    public PagosServiceImpl(PagosRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pagos> listar() {
        return repository.findAll();
    }

    @Override
    public Pagos obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Pago con ID " + id + " no encontrado"));

    }

    @Override
    public Pagos guardar(Pagos pago) {
        return repository.save(pago);
    }

    @Override
    public Pagos actualizar(Long id, Pagos pago) {
        pago.setIdPago(id);
        return repository.save(pago);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
