package com.s1.proyecto1.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record DetalleVentaResponseDTO(
        @Schema(description = "se obtiene el ID del detallventa")
        Long id,
        @Schema(description = "se obtiene el ID del producto")
        ProductoResponseDTO productoId,
        @Schema(description = "se obtiene el ID de la venta")
        VentaResponseDTO ventaId,
        @Schema(description = "se obtiene el la cantidad comprada")
        Integer cantidad,
        @Schema(description = "se obtiene el subtotal de la venta")
        BigDecimal subtotal
) {

}
