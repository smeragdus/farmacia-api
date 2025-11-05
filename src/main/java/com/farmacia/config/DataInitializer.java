package com.farmacia.config;

import com.farmacia.entity.*;
import com.farmacia.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(
            RolesRepository rolesRepo,
            EmpleadosRepository empleadosRepo,
            ProveedorRepository proveedorRepo,
            ProductosRepository productosRepo
    ) {
        return args -> {

            // ========== SEED ROLES ==========
            if (rolesRepo.count() == 0) {
                rolesRepo.save(new Roles(null, "ADMIN"));
                rolesRepo.save(new Roles(null, "FARMACEUTICO"));
                rolesRepo.save(new Roles(null, "CAJERO"));
            }

            // ========== SEED EMPLEADO ADMIN ==========
            if (empleadosRepo.count() == 0) {
                Roles rolAdmin = rolesRepo.findByNombreRol("ADMIN")
                        .orElseThrow(() -> new RuntimeException("Rol ADMIN no encontrado"));


                Empleados admin = Empleados.builder()
                        .rol(rolAdmin)
                        .nombre("Administrador")
                        .apellido("Principal")
                        .estadoCuenta("ACTIVO")
                        .cargo("ADMINISTRADOR")
                        .usuarioSistema("admin")
                        .contrasenaHash("$2a$10$e0NRyqLrQGJ7O5AfO5qF8Ot3UKwR3t/V4OfCEbiYSLpIYCMrH/ME6") // admin123
                        .build();

                empleadosRepo.save(admin);
            }

            // ========== SEED PROVEEDOR ==========
            if (proveedorRepo.count() == 0) {
                proveedorRepo.save(Proveedor.builder()
                        .nombreEmpresa("Laboratorio Genérico")
                        .ruc("12345678901")
                        .telefono("987654321")
                        .email("proveedor@demo.com")
                        .build());
            }

            // ========== SEED PRODUCTOS ==========
            if (productosRepo.count() == 0) {

                Proveedor proveedor = proveedorRepo.findAll().get(0);

                productosRepo.save(Productos.builder()
                        .proveedor(proveedor)
                        .nombreComercial("Paracetamol 500mg")
                        .principioActivo("Paracetamol")
                        .requiereReceta(false)
                        .precioVentaUnitario(1.50)
                        .precioCosto(0.80)
                        .unidadMedida("Tableta")
                        .build());

                productosRepo.save(Productos.builder()
                        .proveedor(proveedor)
                        .nombreComercial("Ibuprofeno 400mg")
                        .principioActivo("Ibuprofeno")
                        .requiereReceta(false)
                        .precioVentaUnitario(2.00)
                        .precioCosto(1.00)
                        .unidadMedida("Tableta")
                        .build());
            }

            System.out.println("✅ SEED cargado correctamente");
        };
    }
}
