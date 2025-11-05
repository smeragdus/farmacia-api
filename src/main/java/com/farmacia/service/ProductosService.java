package com.farmacia.service;

import com.farmacia.entity.Productos;
import java.util.List;

public interface ProductosService {

    List<Productos> listar();
    Productos obtenerPorId(Long id);
    Productos guardar(Productos producto);
    Productos actualizar(Long id, Productos producto);
    void eliminar(Long id);
}
