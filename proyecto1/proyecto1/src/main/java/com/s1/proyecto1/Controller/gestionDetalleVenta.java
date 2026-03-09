package com.s1.proyecto1.Controller;

import com.s1.proyecto1.dto.request.DetalleVentaRequestDTO;
import com.s1.proyecto1.dto.response.DetalleVentaResponseDTO;
import com.s1.proyecto1.service.DetalleVentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalleVenta")
@RequiredArgsConstructor
@Validated
@Tag(name="DetalleVenta", description = "esta api procesa toda la relacion de detalles de venta")
public class gestionDetalleVenta {
    private final DetalleVentaService DetalleVentaService;
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "detalleventa creado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "guardar un detalleventa",description = "permite guardar un detalleventa añadiendo como endpoint (POST) ")
    public ResponseEntity<DetalleVentaResponseDTO> guardar(@Valid @RequestBody DetalleVentaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(DetalleVentaService.guardarDetalle(dto));
    }
    @PutMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "detalleventa actualizado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "actualizar un detalleVenta",description = "permite actualizar un detalleVenta añadiendo como endpoint (PUT)")
    public ResponseEntity<DetalleVentaResponseDTO> actualizar (
            @Valid
            @Parameter(description = "ID de el detalleventa a actualizar ",example = "1")
            @RequestBody DetalleVentaRequestDTO dto,
            @PathVariable Long id
    ){
        return ResponseEntity.ok().body(DetalleVentaService.actualizarDetalleventa(dto, id));
    }
    @GetMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "detalleventa obtenido exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "Lista todos los detalleventa",description = "permite listar todos los detalleventa añadiendo como endpoint (GET)")
    @Valid
    public ResponseEntity<List<DetalleVentaResponseDTO>> Listartodo(){
        return ResponseEntity.ok().body(DetalleVentaService.vertodo());
    }
    @DeleteMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "detalleventa eliminado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "eliminar un detalleVenta",description = "permite eliminar un detalleVenta , añadiendo como endpoint (DELETE)")
    public ResponseEntity<Void> eliminarProducto(
            @Valid
            @Parameter(description = "ID de el detalleventa a eliminar",example = "1")
            @PathVariable Long id){
        DetalleVentaService.eliminarDetalleventa(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
