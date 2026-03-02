package com.s1.proyecto1.service;

import com.s1.proyecto1.dto.request.DetalleVentaRequestDTO;
import com.s1.proyecto1.dto.response.DetalleVentaResponseDTO;

import java.util.List;

public interface DetalleVentaService {
    DetalleVentaResponseDTO guardarDetalle(DetalleVentaRequestDTO dto);
    DetalleVentaResponseDTO actualizarDetalleventa(DetalleVentaRequestDTO dto,Long id);
    void eliminarDetalleventa (Long id);
    List<DetalleVentaResponseDTO> vertodo();
}
