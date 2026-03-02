package com.s1.proyecto1.repository;

import com.s1.proyecto1.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    List<DetalleVenta> findByCantidadGreaterThan(Integer cantidad);
}
