package com.farmacia.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class DetalleVentaDTO {

    private Long idDetalleVenta;

    @NotNull(message = "El producto es obligatorio")
    private Long idProducto;

    @NotNull(message = "La venta es obligatoria")
    private Long idVenta;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad mínima es 1")
    private Integer cantidadVendida;

    @NotNull(message = "El precio unitario es obligatorio")
    @Positive(message = "El precio unitario debe ser mayor a 0")
    private Double precioUnitarioAplicado;

    @NotNull(message = "El subtotal es obligatorio")
    @Positive(message = "El subtotal debe ser mayor a 0")
    private Double subtotal;

    @NotBlank(message = "El número de lote vendido es obligatorio")
    private String numeroLoteVendido;
}
