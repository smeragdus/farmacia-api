package com.farmacia.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "venta")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleados empleado;

    @ManyToOne
    @JoinColumn(name = "id_turno", nullable = false)
    private TurnoTrabajo turno;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "monto_total_venta", nullable = false)
    private Double montoTotalVenta;

    @Column(name = "tipo_venta", nullable = false, length = 20)
    private String tipoVenta;

    @Column(name = "estado_pago", nullable = false, length = 20)
    private String estadoPago;

    @Column(name = "tipo_comprobante", nullable = false, length = 50)
    private String tipoComprobante;

    @Column(name = "fecha_hora_venta")
    private LocalDateTime fechaHoraVenta;
}
