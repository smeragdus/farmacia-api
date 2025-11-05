package com.farmacia.service;

import com.farmacia.entity.TurnoTrabajo;
import java.util.List;

public interface TurnoTrabajoService {

    List<TurnoTrabajo> listar();
    TurnoTrabajo obtenerPorId(Long id);
    TurnoTrabajo guardar(TurnoTrabajo turno);
    TurnoTrabajo actualizar(Long id, TurnoTrabajo turno);
    void eliminar(Long id);
}
