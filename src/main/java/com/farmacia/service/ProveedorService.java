package com.farmacia.service;

import com.farmacia.entity.Proveedor;
import java.util.List;

public interface ProveedorService {

    List<Proveedor> listar();
    Proveedor obtenerPorId(Long id);
    Proveedor guardar(Proveedor proveedor);
    Proveedor actualizar(Long id, Proveedor proveedor);
    void eliminar(Long id);
}
