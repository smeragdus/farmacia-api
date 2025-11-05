package com.farmacia.mapper;

import com.farmacia.dto.TurnoTrabajoDTO;
import com.farmacia.entity.TurnoTrabajo;
import com.farmacia.entity.Empleados;

public class TurnoTrabajoMapper {

    public static TurnoTrabajoDTO toDTO(TurnoTrabajo entity) {
        if (entity == null) return null;
        TurnoTrabajoDTO dto = new TurnoTrabajoDTO();
        dto.setIdTurno(entity.getIdTurno());
        dto.setIdEmpleado(entity.getEmpleado().getIdEmpleado());
        dto.setFechaInicioTurno(entity.getFechaInicioTurno() != null ? entity.getFechaInicioTurno().toString() : null);
        dto.setHoraInicioTurno(entity.getHoraInicioTurno() != null ? entity.getHoraInicioTurno().toString() : null);
        dto.setFechaFinTurno(entity.getFechaFinTurno() != null ? entity.getFechaFinTurno().toString() : null);
        dto.setHoraFinTurno(entity.getHoraFinTurno() != null ? entity.getHoraFinTurno().toString() : null);
        dto.setEstadoTurno(entity.getEstadoTurno());
        dto.setCajaInicial(entity.getCajaInicial());
        return dto;
    }

    public static TurnoTrabajo toEntity(TurnoTrabajoDTO dto) {
        if (dto == null) return null;
        TurnoTrabajo entity = new TurnoTrabajo();
        entity.setIdTurno(dto.getIdTurno());
        entity.setEmpleado(Empleados.builder().idEmpleado(dto.getIdEmpleado()).build());
        entity.setEstadoTurno(dto.getEstadoTurno());
        entity.setCajaInicial(dto.getCajaInicial());
        return entity;
    }
}
