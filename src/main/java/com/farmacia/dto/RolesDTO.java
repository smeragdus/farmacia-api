package com.farmacia.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RolesDTO {

    private Long idRol;

    @NotBlank(message = "El nombre del rol es obligatorio")
    private String nombreRol;
}
