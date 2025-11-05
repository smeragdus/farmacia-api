package com.farmacia.service;

import com.farmacia.entity.Pagos;
import java.util.List;

public interface PagosService {

    List<Pagos> listar();
    Pagos obtenerPorId(Long id);
    Pagos guardar(Pagos pago);
    Pagos actualizar(Long id, Pagos pago);
    void eliminar(Long id);
}
