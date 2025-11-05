package com.farmacia.repository;

import com.farmacia.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByNombreRol(String nombreRol);

}
