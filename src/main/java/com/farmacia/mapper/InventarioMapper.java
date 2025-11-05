package com.farmacia.mapper;

import com.farmacia.dto.InventarioDTO;
import com.farmacia.entity.Inventario;
import com.farmacia.entity.Productos;

public class InventarioMapper {

    public static InventarioDTO toDTO(Inventario entity) {
        if (entity == null) return null;
        InventarioDTO dto = new InventarioDTO();
        dto.setIdInventario(entity.getIdInventario());
        dto.setIdProducto(entity.getProducto().getIdProducto());
        dto.setNumeroLote(entity.getNumeroLote());
        dto.setFechaCaducidad(entity.getFechaCaducidad() != null ? entity.getFechaCaducidad().toString() : null);
        dto.setCantidadStockActual(entity.getCantidadStockActual());
        dto.setUbicacionAlmacen(entity.getUbicacionAlmacen());
        return dto;
    }

    public static Inventario toEntity(InventarioDTO dto) {
        if (dto == null) return null;
        Inventario entity = new Inventario();
        entity.setIdInventario(dto.getIdInventario());
        entity.setProducto(Productos.builder().idProducto(dto.getIdProducto()).build());
        entity.setNumeroLote(dto.getNumeroLote());
        entity.setCantidadStockActual(dto.getCantidadStockActual());
        entity.setUbicacionAlmacen(dto.getUbicacionAlmacen());
        return entity;
    }
}
