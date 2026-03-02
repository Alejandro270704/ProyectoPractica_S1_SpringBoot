package com.s1.proyecto1.mapper;

import com.s1.proyecto1.dto.request.ProductoRequestDto;
import com.s1.proyecto1.dto.response.ProductoResponseDTO;
import com.s1.proyecto1.model.Producto;
import org.springframework.stereotype.Component;


@Component
public class ProductoMapper {
    public ProductoResponseDTO entidadADTO(Producto producto) {
        if (producto == null) return null;
        return new ProductoResponseDTO(
                producto.getId(), producto.getNombre(),
                producto.getPrecio(),
                producto.getStock()
        );
    }

    public Producto DTOAEntidad(ProductoRequestDto dto) {
        if (dto == null) return null;
        Producto p = new Producto();
        p.setNombre(dto.nombre());
        p.setPrecio(dto.precio());
        p.setStock(dto.stock());
        return p;
    }

    public void actualizarEntidadDesdeDTO(Producto producto, ProductoRequestDto dto) {
        if (producto == null || dto == null) return;
        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
    }

}
