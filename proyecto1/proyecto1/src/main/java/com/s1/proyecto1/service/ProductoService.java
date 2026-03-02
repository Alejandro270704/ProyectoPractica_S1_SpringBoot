package com.s1.proyecto1.service;

import com.s1.proyecto1.dto.request.ProductoRequestDto;
import com.s1.proyecto1.dto.response.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {
    ProductoResponseDTO guardarProducto(ProductoRequestDto dto);

    ProductoResponseDTO actualizarProducto(ProductoRequestDto dto, Long id);
    void eliminarProducto(Long id);
    List<ProductoResponseDTO> buscarTodos();
    List<ProductoResponseDTO> buscarProductoStockBajo(int Stock);
    List<ProductoResponseDTO> buscarProductosLetra (String letra);
}
