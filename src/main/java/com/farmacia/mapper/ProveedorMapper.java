package com.farmacia.mapper;

import com.farmacia.dto.ProveedorDTO;
import com.farmacia.entity.Proveedor;

public class ProveedorMapper {

    public static ProveedorDTO toDTO(Proveedor entity) {
        if (entity == null) return null;
        ProveedorDTO dto = new ProveedorDTO();
        dto.setIdProveedor(entity.getIdProveedor());
        dto.setNombreEmpresa(entity.getNombreEmpresa());
        dto.setRuc(entity.getRuc());
        dto.setTelefono(entity.getTelefono());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public static Proveedor toEntity(ProveedorDTO dto) {
        if (dto == null) return null;
        return Proveedor.builder()
                .idProveedor(dto.getIdProveedor())
                .nombreEmpresa(dto.getNombreEmpresa())
                .ruc(dto.getRuc())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .build();
    }
}
