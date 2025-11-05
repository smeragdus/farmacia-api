package com.farmacia.service;

import com.farmacia.entity.DetalleVenta;
import java.util.List;

public interface DetalleVentaService {

    List<DetalleVenta> listar();
    DetalleVenta obtenerPorId(Long id);
    DetalleVenta guardar(DetalleVenta detalle);
    DetalleVenta actualizar(Long id, DetalleVenta detalle);
    void eliminar(Long id);
}
