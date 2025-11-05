package com.farmacia.service;

import com.farmacia.entity.Venta;
import java.util.List;

public interface VentaService {

    List<Venta> listar();
    Venta obtenerPorId(Long id);
    Venta guardar(Venta venta);
    Venta actualizar(Long id, Venta venta);
    void eliminar(Long id);
}
