package com.farmacia.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class VentaDTO {

    private Long idVenta;

    @NotNull(message = "El empleado es obligatorio")
    private Long idEmpleado;

    @NotNull(message = "El turno es obligatorio")
    private Long idTurno;

    @NotNull(message = "El cliente es obligatorio")
    private Long idCliente;

    @NotNull(message = "El monto total es obligatorio")
    @Positive(message = "El monto total debe ser mayor a 0")
    private Double montoTotalVenta;

    @NotBlank(message = "El tipo de venta es obligatorio")
    private String tipoVenta;

    @NotBlank(message = "El estado de pago es obligatorio")
    private String estadoPago;

    @NotBlank(message = "El tipo de comprobante es obligatorio")
    private String tipoComprobante;

    private String fechaHoraVenta;
}
