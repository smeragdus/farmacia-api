package com.farmacia.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long idPago;

    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;

    @Column(name = "metodo_pago", nullable = false, length = 50)
    private String metodoPago;

    @Column(name = "monto_pagado", nullable = false)
    private Double montoPagado;

    @Column(name = "referencia_transaccion", length = 150)
    private String referenciaTransaccion;

    @Column(name = "fecha_hora_pago")
    private LocalDateTime fechaHoraPago;
}
