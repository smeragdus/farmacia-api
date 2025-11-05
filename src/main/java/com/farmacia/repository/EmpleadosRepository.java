package com.farmacia.repository;

import com.farmacia.entity.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {
}
