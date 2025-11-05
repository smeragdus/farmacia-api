package com.farmacia.service;

import com.farmacia.entity.Empleados;
import java.util.List;

public interface EmpleadosService {

    List<Empleados> listar();
    Empleados obtenerPorId(Long id);
    Empleados guardar(Empleados empleado);
    Empleados actualizar(Long id, Empleados empleado);
    void eliminar(Long id);
}
