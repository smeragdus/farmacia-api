package com.farmacia.service;

import com.farmacia.entity.Cliente;
import java.util.List;

public interface ClienteService {

    List<Cliente> listar();
    Cliente obtenerPorId(Long id);
    Cliente guardar(Cliente cliente);
    Cliente actualizar(Long id, Cliente cliente);
    void eliminar(Long id);
}
