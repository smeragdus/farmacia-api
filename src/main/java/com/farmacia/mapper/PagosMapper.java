package com.farmacia.mapper;

import com.farmacia.dto.PagosDTO;
import com.farmacia.entity.Pagos;
import com.farmacia.entity.Venta;

public class PagosMapper {

    public static PagosDTO toDTO(Pagos entity) {
        if (entity == null) return null;
        PagosDTO dto = new PagosDTO();
        dto.setIdPago(entity.getIdPago());
        dto.setIdVenta(entity.getVenta().getIdVenta());
        dto.setMetodoPago(entity.getMetodoPago());
        dto.setMontoPagado(entity.getMontoPagado());
        dto.setReferenciaTransaccion(entity.getReferenciaTransaccion());
        dto.setFechaHoraPago(entity.getFechaHoraPago() != null ? entity.getFechaHoraPago().toString() : null);
        return dto;
    }

    public static Pagos toEntity(PagosDTO dto) {
        if (dto == null) return null;
        Pagos entity = new Pagos();
        entity.setIdPago(dto.getIdPago());
        entity.setVenta(Venta.builder().idVenta(dto.getIdVenta()).build());
        entity.setMetodoPago(dto.getMetodoPago());
        entity.setMontoPagado(dto.getMontoPagado());
        entity.setReferenciaTransaccion(dto.getReferenciaTransaccion());
        return entity;
    }
}
