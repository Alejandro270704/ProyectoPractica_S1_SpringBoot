package com.s1.proyecto1.repository;

import com.s1.proyecto1.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface productoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByStockLessThan(Integer stock);
    List<Producto> findByNombreContaining(String letra);
}
