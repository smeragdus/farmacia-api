package com.farmacia.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "turno_trabajo")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class TurnoTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private Long idTurno;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleados empleado;

    private LocalDate fechaInicioTurno;
    private LocalTime horaInicioTurno;
    private LocalDate fechaFinTurno;
    private LocalTime horaFinTurno;

    @Column(name = "estado_turno", nullable = false, length = 20)
    private String estadoTurno;

    @Column(name = "caja_inicial", nullable = false)
    private Double cajaInicial;
}
