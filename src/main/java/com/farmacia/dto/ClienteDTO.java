package com.farmacia.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ClienteDTO {

    private Long idCliente;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @Size(min = 8, max = 12, message = "El documento debe tener entre 8 y 12 caracteres")
    private String numeroDocumento;

    @Pattern(regexp = "^[0-9]{11}$", message = "El RUC debe tener 11 dígitos")
    private String ruc;

    @Pattern(regexp = "^[0-9]{9}$", message = "El teléfono debe tener entre 9 dígitos")
    private String telefono;

    @Email(message = "Correo electrónico inválido")
    private String email;
}
