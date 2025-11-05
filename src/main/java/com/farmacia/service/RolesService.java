package com.farmacia.service;

import com.farmacia.entity.Roles;
import java.util.List;

public interface RolesService {

    List<Roles> listar();
    Roles obtenerPorId(Long id);
    Roles guardar(Roles roles);
    Roles actualizar(Long id, Roles roles);
    void eliminar(Long id);
}
