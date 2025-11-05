package com.farmacia.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PagosDTO {

    private Long idPago;

    @NotNull(message = "La venta es obligatoria")
    private Long idVenta;

    @NotBlank(message = "El método de pago es obligatorio")
    private String metodoPago;

    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser mayor a 0")
    private Double montoPagado;

    private String referenciaTransaccion;

    private String fechaHoraPago;
}
