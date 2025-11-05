package com.farmacia.service.impl;

import com.farmacia.entity.Roles;
import com.farmacia.exception.RecursoNoEncontradoException;
import com.farmacia.repository.RolesRepository;
import com.farmacia.service.RolesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {

    private final RolesRepository repository;

    public RolesServiceImpl(RolesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Roles> listar() {
        return repository.findAll();
    }

    @Override
    public Roles obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Rol con ID " + id + " no encontrado"));

    }

    @Override
    public Roles guardar(Roles roles) {
        return repository.save(roles);
    }

    @Override
    public Roles actualizar(Long id, Roles roles) {
        roles.setIdRol(id);
        return repository.save(roles);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
