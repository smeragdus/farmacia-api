package com.farmacia.mapper;

import com.farmacia.dto.RolesDTO;
import com.farmacia.entity.Roles;

public class RolesMapper {

    public static RolesDTO toDTO(Roles entity) {
        if (entity == null) return null;
        RolesDTO dto = new RolesDTO();
        dto.setIdRol(entity.getIdRol());
        dto.setNombreRol(entity.getNombreRol());
        return dto;
    }

    public static Roles toEntity(RolesDTO dto) {
        if (dto == null) return null;
        return Roles.builder()
                .idRol(dto.getIdRol())
                .nombreRol(dto.getNombreRol())
                .build();
    }
}
