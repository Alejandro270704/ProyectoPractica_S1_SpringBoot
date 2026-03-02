package com.s1.proyecto1.mapper;

import com.s1.proyecto1.dto.request.DetalleVentaRequestDTO;
import com.s1.proyecto1.dto.response.DetalleVentaResponseDTO;
import com.s1.proyecto1.dto.response.VentaResponseDTO;
import com.s1.proyecto1.model.DetalleVenta;
import com.s1.proyecto1.dto.response.ProductoResponseDTO;
import com.s1.proyecto1.model.Producto;
import com.s1.proyecto1.model.Venta;
import org.springframework.stereotype.Component;

@Component
public class DetalleVentaMapper {
    public DetalleVentaResponseDTO entidadADTO(DetalleVenta detalleVenta, ProductoResponseDTO dtoproducto, VentaResponseDTO dtoventa) {
        if (detalleVenta == null || dtoproducto == null || dtoventa==null) return null;
        return new DetalleVentaResponseDTO(
                detalleVenta.getId(),
                detalleVenta.getProducto().getId(),
                detalleVenta.getVenta().getId(),
                detalleVenta.getCantidad(),
                detalleVenta.getSubtotal()
        );
    }

    public DetalleVenta DTOAEntidad(DetalleVentaRequestDTO dto, Producto producto, Venta venta) {
        if (dto == null) return null;
        DetalleVenta d = new DetalleVenta();
        d.setCantidad(dto.cantidad());
        d.setSubtotal(dto.subtotal());
        d.setProducto(producto);
        d.setVenta(venta);
        return d;
    }

    public void actualizarEntidadDesdeDTO(DetalleVenta detalleVenta, DetalleVentaRequestDTO dto,Producto producto,Venta venta) {
        if (detalleVenta == null || dto == null) return;
        detalleVenta.setCantidad(dto.cantidad());
        detalleVenta.setSubtotal(dto.subtotal());

    }
}
