package com.farmacia.service;

import com.farmacia.entity.Inventario;
import java.util.List;

public interface InventarioService {

    List<Inventario> listar();
    Inventario obtenerPorId(Long id);
    Inventario guardar(Inventario inventario);
    Inventario actualizar(Long id, Inventario inventario);
    void eliminar(Long id);
}
