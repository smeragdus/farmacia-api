package com.farmacia.mapper;

import com.farmacia.dto.VentaDTO;
import com.farmacia.entity.*;

public class VentaMapper {

    public static VentaDTO toDTO(Venta entity) {
        if (entity == null) return null;
        VentaDTO dto = new VentaDTO();
        dto.setIdVenta(entity.getIdVenta());
        dto.setIdEmpleado(entity.getEmpleado().getIdEmpleado());
        dto.setIdTurno(entity.getTurno().getIdTurno());
        dto.setIdCliente(entity.getCliente().getIdCliente());
        dto.setMontoTotalVenta(entity.getMontoTotalVenta());
        dto.setTipoVenta(entity.getTipoVenta());
        dto.setEstadoPago(entity.getEstadoPago());
        dto.setTipoComprobante(entity.getTipoComprobante());
        dto.setFechaHoraVenta(entity.getFechaHoraVenta() != null ? entity.getFechaHoraVenta().toString() : null);
        return dto;
    }

    public static Venta toEntity(VentaDTO dto) {
        if (dto == null) return null;
        Venta entity = new Venta();
        entity.setIdVenta(dto.getIdVenta());
        entity.setEmpleado(Empleados.builder().idEmpleado(dto.getIdEmpleado()).build());
        entity.setTurno(TurnoTrabajo.builder().idTurno(dto.getIdTurno()).build());
        entity.setCliente(Cliente.builder().idCliente(dto.getIdCliente()).build());
        entity.setMontoTotalVenta(dto.getMontoTotalVenta());
        entity.setTipoVenta(dto.getTipoVenta());
        entity.setEstadoPago(dto.getEstadoPago());
        entity.setTipoComprobante(dto.getTipoComprobante());
        return entity;
    }
}
