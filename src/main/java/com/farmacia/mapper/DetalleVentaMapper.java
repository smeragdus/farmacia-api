package com.farmacia.mapper;

import com.farmacia.dto.DetalleVentaDTO;
import com.farmacia.entity.*;

public class DetalleVentaMapper {

    public static DetalleVentaDTO toDTO(DetalleVenta entity) {
        if (entity == null) return null;
        DetalleVentaDTO dto = new DetalleVentaDTO();
        dto.setIdDetalleVenta(entity.getIdDetalleVenta());
        dto.setIdProducto(entity.getProducto().getIdProducto());
        dto.setIdVenta(entity.getVenta().getIdVenta());
        dto.setCantidadVendida(entity.getCantidadVendida());
        dto.setPrecioUnitarioAplicado(entity.getPrecioUnitarioAplicado());
        dto.setSubtotal(entity.getSubtotal());
        dto.setNumeroLoteVendido(entity.getNumeroLoteVendido());
        return dto;
    }

    public static DetalleVenta toEntity(DetalleVentaDTO dto) {
        if (dto == null) return null;
        DetalleVenta entity = new DetalleVenta();
        entity.setIdDetalleVenta(dto.getIdDetalleVenta());
        entity.setProducto(Productos.builder().idProducto(dto.getIdProducto()).build());
        entity.setVenta(Venta.builder().idVenta(dto.getIdVenta()).build());
        entity.setCantidadVendida(dto.getCantidadVendida());
        entity.setPrecioUnitarioAplicado(dto.getPrecioUnitarioAplicado());
        entity.setSubtotal(dto.getSubtotal());
        entity.setNumeroLoteVendido(dto.getNumeroLoteVendido());
        return entity;
    }
}
