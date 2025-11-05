package com.farmacia.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TurnoTrabajoDTO {

    private Long idTurno;

    @NotNull(message = "El empleado es obligatorio")
    private Long idEmpleado;

    private String fechaInicioTurno;
    private String horaInicioTurno;
    private String fechaFinTurno;
    private String horaFinTurno;

    @NotNull(message = "El estado del turno es obligatorio")
    private String estadoTurno;

    @NotNull(message = "La caja inicial es obligatoria")
    private Double cajaInicial;
}
