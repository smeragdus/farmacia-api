package com.farmacia.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductosDTO {

    private Long idProducto;

    @NotNull(message = "El proveedor es obligatorio")
    private Long idProveedor;

    @NotBlank(message = "El nombre comercial es obligatorio")
    private String nombreComercial;

    private String principioActivo;

    @NotNull(message = "Debe indicar si requiere receta")
    private Boolean requiereReceta;

    @NotNull(message = "El precio de venta es obligatorio")
    @Positive(message = "El precio de venta debe ser mayor a 0")
    private Double precioVentaUnitario;

    @NotBlank(message = "La unidad de medida es obligatoria")
    private String unidadMedida;

    @NotNull(message = "El precio de costo es obligatorio")
    @Positive(message = "El precio de costo debe ser mayor a 0")
    private Double precioCosto;
}
