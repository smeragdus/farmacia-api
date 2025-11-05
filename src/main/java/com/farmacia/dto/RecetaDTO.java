package com.farmacia.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RecetaDTO {

    private Long idReceta;

    @NotNull(message = "La venta asociada es obligatoria")
    private Long idVenta;

    @NotNull(message = "El cliente es obligatorio")
    private Long idCliente;

    @NotBlank(message = "El nombre del médico es obligatorio")
    private String nombreMedico;

    @NotBlank(message = "La matrícula del médico es obligatoria")
    private String matriculaMedico;

    private String fechaEmision;
    private String fechaDispensacion;
}
