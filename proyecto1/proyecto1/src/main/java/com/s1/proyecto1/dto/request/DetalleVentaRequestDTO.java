package com.s1.proyecto1.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record DetalleVentaRequestDTO(
        @Schema(description = "se ingresa el ID del producto")
        Long productoId,
        @Schema(description = "se ingresa el ID de la venta")
        Long ventaId,
        @Schema(description = "se ingresa la cantidad de productos a comprar")
        Integer cantidad,
        @Schema(description = "se ingresa subtotal")
        BigDecimal subtotal
) {
}
