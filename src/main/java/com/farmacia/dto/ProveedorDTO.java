package com.farmacia.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProveedorDTO {

    private Long idProveedor;

    @NotBlank(message = "El nombre de la empresa es obligatorio")
    private String nombreEmpresa;

    @Pattern(regexp = "^[0-9]{11}$", message = "El RUC debe tener 11 dígitos")
    private String ruc;

    @Pattern(regexp = "^[0-9]{7,15}$", message = "El teléfono debe tener entre 7 y 15 dígitos")
    private String telefono;

    @Email(message = "Correo electrónico inválido")
    private String email;
}
