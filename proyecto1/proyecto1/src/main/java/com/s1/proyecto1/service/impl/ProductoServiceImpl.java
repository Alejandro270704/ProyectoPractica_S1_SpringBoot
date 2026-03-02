package com.s1.proyecto1.service.impl;

import com.s1.proyecto1.mapper.ProductoMapper;
import com.s1.proyecto1.dto.request.ProductoRequestDto;
import com.s1.proyecto1.dto.response.ProductoResponseDTO;
import com.s1.proyecto1.model.Producto;
import com.s1.proyecto1.service.ProductoService;
import com.s1.proyecto1.repository.productoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
    private final ProductoMapper ProductoMapper;
    private final  productoRepository productoRepository;
    @Override
    public ProductoResponseDTO guardarProducto(ProductoRequestDto dto) {
        Producto p=ProductoMapper.DTOAEntidad(dto);
        Producto p_insertada=productoRepository.save(p);
        return ProductoMapper.entidadADTO(p_insertada);
    }

    @Override
    public ProductoResponseDTO actualizarProducto(ProductoRequestDto dto, Long id) {
        Producto p=productoRepository.findById(id).orElseThrow(()->new RuntimeException("No existe dicha profesion"));
        ProductoMapper.actualizarEntidadDesdeDTO(p,dto);
        Producto p_actualizada=productoRepository.save(p);
        return ProductoMapper.entidadADTO(p_actualizada);
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto p=productoRepository.findById(id).orElseThrow(()->new RuntimeException("No existe dicha profesion"));
        productoRepository.delete(p);
    }

    @Override
    public List<ProductoResponseDTO> buscarTodos() {
        List<Producto> productos= productoRepository.findAll();
        return productos.stream().map(ProductoMapper::entidadADTO).toList();
    }

    @Override
    public List<ProductoResponseDTO> buscarProductoStockBajo(int Stock) {
        List<Producto> productos= productoRepository.findByStockLessThan(Stock);
        return productos.stream().map(ProductoMapper::entidadADTO).toList();
    }

    @Override
    public List<ProductoResponseDTO> buscarProductosLetra(String letra) {
        List<Producto> productos= productoRepository.findByNombreContaining(letra);
        return productos.stream().map(ProductoMapper::entidadADTO).toList();
    }
}
