package com.farmacia.service.impl;

import com.farmacia.entity.Cliente;
import com.farmacia.exception.RecursoNoEncontradoException;
import com.farmacia.repository.ClienteRepository;
import com.farmacia.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @Override
    public Cliente obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente con ID " + id + " no encontrado"));

    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente actualizar(Long id, Cliente cliente) {
        cliente.setIdCliente(id);
        return repository.save(cliente);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
