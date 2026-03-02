package com.s1.proyecto1.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record VentaRequestDTO(
        @Schema(description = "se ingresa el total de la venta")
        BigDecimal total
) {
}
