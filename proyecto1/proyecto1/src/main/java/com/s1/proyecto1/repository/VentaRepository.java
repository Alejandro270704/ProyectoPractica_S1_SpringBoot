package com.s1.proyecto1.repository;

import com.s1.proyecto1.model.Venta;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByTotalGreaterThan(BigDecimal limiter);

}
