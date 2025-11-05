package com.farmacia.service;

import com.farmacia.entity.Receta;
import java.util.List;

public interface RecetaService {

    List<Receta> listar();
    Receta obtenerPorId(Long id);
    Receta guardar(Receta receta);
    Receta actualizar(Long id, Receta receta);
    void eliminar(Long id);
}
