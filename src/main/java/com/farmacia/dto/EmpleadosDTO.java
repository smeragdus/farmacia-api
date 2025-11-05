package com.farmacia.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmpleadosDTO {

    private Long idEmpleado;

    @NotNull(message = "El rol es obligatorio")
    private Long idRol;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "El estado de la cuenta es obligatorio")
    private String estadoCuenta;

    @NotBlank(message = "El cargo es obligatorio")
    private String cargo;

    @NotBlank(message = "El usuario del sistema es obligatorio")
    private String usuarioSistema;
}
