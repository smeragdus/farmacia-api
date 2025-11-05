package com.farmacia.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class InventarioDTO {

    private Long idInventario;

    @NotNull(message = "El producto es obligatorio")
    private Long idProducto;

    @NotBlank(message = "El número de lote es obligatorio")
    private String numeroLote;

    @NotBlank(message = "La fecha de caducidad es obligatoria")
    private String fechaCaducidad;

    @NotNull(message = "La cantidad en stock es obligatoria")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer cantidadStockActual;

    @NotBlank(message = "La ubicación en almacén es obligatoria")
    private String ubicacionAlmacen;
}
