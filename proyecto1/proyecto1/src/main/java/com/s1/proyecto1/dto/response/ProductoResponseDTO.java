package com.s1.proyecto1.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record ProductoResponseDTO(
        @Schema(description = "se obtiene el ID del producto")
        Long id,
        @Schema(description = "se obtiene el nombre del producto")
        String nombre,
        @Schema(description = "se obtiene el precio del producto")
        BigDecimal precio,
        @Schema(description = "se obtiene la descripcion del producto")
        Integer stock
) {
}
