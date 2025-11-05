package com.farmacia.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empleados")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long idEmpleado;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Roles rol;

    @Column(nullable = false, length = 120)
    private String nombre;

    @Column(nullable = false, length = 120)
    private String apellido;

    @Column(name = "estado_cuenta", nullable = false, length = 20)
    private String estadoCuenta;

    @Column(nullable = false, length = 100)
    private String cargo;

    @Column(name = "usuario_sistema", nullable = false, length = 50, unique = true)
    private String usuarioSistema;

    @Column(name = "contrasena_hash", nullable = false, length = 255)
    private String contrasenaHash;
}
