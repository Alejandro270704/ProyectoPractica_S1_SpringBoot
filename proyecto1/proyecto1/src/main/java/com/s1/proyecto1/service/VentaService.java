package com.s1.proyecto1.service;

import com.s1.proyecto1.dto.request.VentaRequestDTO;
import com.s1.proyecto1.dto.response.VentaResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface VentaService {
    VentaResponseDTO guardarVentas(VentaRequestDTO dto);

    VentaResponseDTO actualizarVentas(VentaRequestDTO dto, Long id);
    void eliminarVentas(Long id);
    List<VentaResponseDTO> buscarTodos();
    List<VentaResponseDTO> buscarventasMayores(BigDecimal limiter);
}
