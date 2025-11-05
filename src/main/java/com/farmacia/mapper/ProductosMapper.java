package com.farmacia.mapper;

import com.farmacia.dto.ProductosDTO;
import com.farmacia.entity.Productos;
import com.farmacia.entity.Proveedor;

public class ProductosMapper {

    public static ProductosDTO toDTO(Productos entity) {
        if (entity == null) return null;
        ProductosDTO dto = new ProductosDTO();
        dto.setIdProducto(entity.getIdProducto());
        dto.setIdProveedor(entity.getProveedor().getIdProveedor());
        dto.setNombreComercial(entity.getNombreComercial());
        dto.setPrincipioActivo(entity.getPrincipioActivo());
        dto.setRequiereReceta(entity.getRequiereReceta());
        dto.setPrecioVentaUnitario(entity.getPrecioVentaUnitario());
        dto.setUnidadMedida(entity.getUnidadMedida());
        dto.setPrecioCosto(entity.getPrecioCosto());
        return dto;
    }

    public static Productos toEntity(ProductosDTO dto) {
        if (dto == null) return null;
        return Productos.builder()
                .idProducto(dto.getIdProducto())
                .proveedor(Proveedor.builder().idProveedor(dto.getIdProveedor()).build())
                .nombreComercial(dto.getNombreComercial())
                .principioActivo(dto.getPrincipioActivo())
                .requiereReceta(dto.getRequiereReceta())
                .precioVentaUnitario(dto.getPrecioVentaUnitario())
                .unidadMedida(dto.getUnidadMedida())
                .precioCosto(dto.getPrecioCosto())
                .build();
    }
}
