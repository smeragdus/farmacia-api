package com.farmacia.mapper;

import com.farmacia.dto.ClienteDTO;
import com.farmacia.entity.Cliente;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente entity) {
        if (entity == null) return null;
        ClienteDTO dto = new ClienteDTO();
        dto.setIdCliente(entity.getIdCliente());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setNumeroDocumento(entity.getNumeroDocumento());
        dto.setRuc(entity.getRuc());
        dto.setTelefono(entity.getTelefono());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public static Cliente toEntity(ClienteDTO dto) {
        if (dto == null) return null;
        return Cliente.builder()
                .idCliente(dto.getIdCliente())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .numeroDocumento(dto.getNumeroDocumento())
                .ruc(dto.getRuc())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .build();
    }
}
