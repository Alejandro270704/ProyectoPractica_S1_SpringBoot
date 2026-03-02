package com.s1.proyecto1.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record ProductoRequestDto(
        @Schema(description = "se ingresa el nombre del producto")
        String nombre,
        @Schema(description = "se ingresa el precio del producto")
        BigDecimal precio,
        @Schema(description = "se ingresa el stock del producto")
        Integer stock
) {
}
