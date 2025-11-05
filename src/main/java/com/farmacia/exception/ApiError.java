package com.farmacia.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
    private String mensaje;
    private String detalle;
}
