package com.farmacia.mapper;

import com.farmacia.dto.RecetaDTO;
import com.farmacia.entity.*;

public class RecetaMapper {

    public static RecetaDTO toDTO(Receta entity) {
        if (entity == null) return null;
        RecetaDTO dto = new RecetaDTO();
        dto.setIdReceta(entity.getIdReceta());
        dto.setIdVenta(entity.getVenta().getIdVenta());
        dto.setIdCliente(entity.getCliente().getIdCliente());
        dto.setNombreMedico(entity.getNombreMedico());
        dto.setMatriculaMedico(entity.getMatriculaMedico());
        dto.setFechaEmision(entity.getFechaEmision() != null ? entity.getFechaEmision().toString() : null);
        dto.setFechaDispensacion(entity.getFechaDispensacion() != null ? entity.getFechaDispensacion().toString() : null);
        return dto;
    }

    public static Receta toEntity(RecetaDTO dto) {
        if (dto == null) return null;
        Receta entity = new Receta();
        entity.setIdReceta(dto.getIdReceta());
        entity.setVenta(Venta.builder().idVenta(dto.getIdVenta()).build());
        entity.setCliente(Cliente.builder().idCliente(dto.getIdCliente()).build());
        entity.setNombreMedico(dto.getNombreMedico());
        entity.setMatriculaMedico(dto.getMatriculaMedico());
        return entity;
    }
}
