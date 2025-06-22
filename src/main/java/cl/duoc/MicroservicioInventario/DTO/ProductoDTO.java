package cl.duoc.MicroservicioInventario.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para representar los datos del producto en las respuestas de la API")
public class ProductoDTO {

    @Schema(description = "Identificador único del producto", example = "1")
    private Long id;

    @Schema(description = "Nombre del producto", example = "Laptop Lenovo ThinkPad")
    private String nombre;

    @Schema(description = "Descripción breve del producto", example = "Laptop de 14 pulgadas con procesador Intel i5")
    private String descripcion;

    @Schema(description = "Cantidad disponible", example = "25")
    private int cantidad;

    @Schema(description = "Precio unitario", example = "599990")
    private double precio;

    // Constructores
    public ProductoDTO() {
    }

    public ProductoDTO(Long id, String nombre, String descripcion, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
