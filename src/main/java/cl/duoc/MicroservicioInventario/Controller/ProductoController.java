package cl.duoc.MicroservicioInventario.Controller;

import cl.duoc.MicroservicioInventario.Model.Producto;
import cl.duoc.MicroservicioInventario.Service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventario")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @Operation(summary = "Obtener todos los productos del inventario")
    @GetMapping
    public List<Producto> getAll() {
        return service.obtenerTodos();
    }

    @Operation(summary = "Obtener un producto por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto encontrado"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
@GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.obtenerPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @Operation(summary = "Guardar un nuevo producto")
    @ApiResponse(responseCode = "200", description = "Producto guardado correctamente")
@PostMapping
    public ResponseEntity<?> save(@RequestBody Producto producto) {
        return ResponseEntity.ok(service.guardar(producto));
    }

    @Operation(summary = "Eliminar un producto por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok("Producto eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
