package com.s1.proyecto1.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record VentaResponseDTO(
        @Schema(description = "se obtiene el ID de la venta")
        Long id,
        @Schema(description = "se obtiene el total de la venta")
        BigDecimal total
) {

}
