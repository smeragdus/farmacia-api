package com.farmacia.service.impl;

import com.farmacia.entity.TurnoTrabajo;
import com.farmacia.exception.RecursoNoEncontradoException;
import com.farmacia.repository.TurnoTrabajoRepository;
import com.farmacia.service.TurnoTrabajoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoTrabajoServiceImpl implements TurnoTrabajoService {

    private final TurnoTrabajoRepository repository;

    public TurnoTrabajoServiceImpl(TurnoTrabajoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TurnoTrabajo> listar() {
        return repository.findAll();
    }

    @Override
    public TurnoTrabajo obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Turno de trabajo con ID " + id + " no encontrado"));

    }

    @Override
    public TurnoTrabajo guardar(TurnoTrabajo turno) {
        return repository.save(turno);
    }

    @Override
    public TurnoTrabajo actualizar(Long id, TurnoTrabajo turno) {
        turno.setIdTurno(id);
        return repository.save(turno);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
