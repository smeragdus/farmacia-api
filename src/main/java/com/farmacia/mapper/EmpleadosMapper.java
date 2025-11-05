package com.farmacia.mapper;

import com.farmacia.dto.EmpleadosDTO;
import com.farmacia.entity.Empleados;
import com.farmacia.entity.Roles;

public class EmpleadosMapper {
    public static EmpleadosDTO toDTO(Empleados entity) {
        if (entity == null) return null;
        EmpleadosDTO dto = new EmpleadosDTO();
        dto.setIdEmpleado(entity.getIdEmpleado());
        dto.setIdRol(entity.getRol().getIdRol());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setEstadoCuenta(entity.getEstadoCuenta());
        dto.setCargo(entity.getCargo());
        dto.setUsuarioSistema(entity.getUsuarioSistema());
        return dto;
    }

    public static Empleados toEntity(EmpleadosDTO dto) {
        if (dto == null) return null;
        return Empleados.builder()
                .idEmpleado(dto.getIdEmpleado())
                .rol(Roles.builder().idRol(dto.getIdRol()).build())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .estadoCuenta(dto.getEstadoCuenta())
                .cargo(dto.getCargo())
                .usuarioSistema(dto.getUsuarioSistema())
                .build();
    }
}
