package com.farmacia.service.impl;

import com.farmacia.entity.Empleados;
import com.farmacia.exception.RecursoNoEncontradoException;
import com.farmacia.repository.EmpleadosRepository;
import com.farmacia.service.EmpleadosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadosServiceImpl implements EmpleadosService {

    private final EmpleadosRepository repository;

    public EmpleadosServiceImpl(EmpleadosRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Empleados> listar() {
        return repository.findAll();
    }

    @Override
    public Empleados obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Empleado con ID " + id + " no encontrado"));

    }

    @Override
    public Empleados guardar(Empleados empleado) {
        return repository.save(empleado);
    }

    @Override
    public Empleados actualizar(Long id, Empleados empleado) {
        empleado.setIdEmpleado(id);
        return repository.save(empleado);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
