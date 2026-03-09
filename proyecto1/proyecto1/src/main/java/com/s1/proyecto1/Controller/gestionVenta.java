package com.s1.proyecto1.Controller;

import com.s1.proyecto1.dto.request.VentaRequestDTO;
import com.s1.proyecto1.dto.response.VentaResponseDTO;
import com.s1.proyecto1.service.impl.VentaServiceImpl;
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
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
@Validated
@Tag(name="venta", description = "esta api procesa toda la relacion de las ventas")
public class gestionVenta {
    private final VentaServiceImpl VentaService;
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "venta creada exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "guardar una Venta",description = "permite guardar un Venta añadiendo como endpoint (POST) ")
    public ResponseEntity<VentaResponseDTO> guardar(@Valid @RequestBody VentaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(VentaService.guardarVentas(dto));
    }
    @PutMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "venta actualizada exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "actualizar una Venta",description = "permite actualizar una Venta añadiendo como endpoint (PUT) ")
    public ResponseEntity<VentaResponseDTO> actualizar (@Valid @Parameter(description = "ID de el venta a actualizar,añadiendo como endpoint (PUT)",example = "1") @RequestBody VentaRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(VentaService.actualizarVentas(dto, id));
    }
    @GetMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "ventas obtenidas exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "Listar un Venta",description = "permite Listar un Venta añadiendo como endpoint (GET) ")
    @Valid
    public ResponseEntity<List<VentaResponseDTO>> ListarTodoProducto(){
        return ResponseEntity.ok().body(VentaService.buscarTodos());
    }
    @DeleteMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "venta eliminada exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "eliminar una Venta",description = "permite eliminar una Venta ,añadiendo como endpoint (DELETE)")
    public ResponseEntity<Void> eliminarProducto(@Valid @Parameter(description = "ID de el venta a eliminar",example = "1") @PathVariable Long id){
        VentaService.eliminarVentas(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
