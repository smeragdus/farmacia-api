package com.farmacia.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 120)
    private String apellido;

    @Column(name = "numero_documento", length = 20, unique = true)
    private String numeroDocumento;

    @Column(length = 15)
    private String ruc;

    @Column(length = 20)
    private String telefono;

    @Column(length = 120)
    private String email;
}
