package com.s1.proyecto1.mapper;

import com.s1.proyecto1.dto.response.VentaResponseDTO;
import com.s1.proyecto1.model.Venta;
import com.s1.proyecto1.dto.request.VentaRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class VentaMapper {
    public VentaResponseDTO entidadADTO(Venta venta) {
        if (venta == null ) return null;
        return new VentaResponseDTO(
                venta.getId(),
                venta.getTotal()
        );
    }

    public Venta DTOAEntidad(VentaRequestDTO dto) {
        if (dto == null) return null;
        Venta v = new Venta();
        v.setTotal(dto.total());
        return v;
    }

    public void actualizarEntidadDesdeDTO(Venta venta, VentaRequestDTO dto) {
        if (venta == null || dto == null) return;
        venta.setTotal(dto.total());
    }
}
