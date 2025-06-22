package cl.duoc.MicroservicioInventario.Config;


import cl.duoc.MicroservicioInventario.Model.Producto;
import cl.duoc.MicroservicioInventario.DTO.ProductoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ProductoAssembler {

    public static ProductoDTO toDTO(Producto producto) {
        return new ProductoDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getCantidad(),
                producto.getPrecio()
        );
    }

    public static Producto toEntity(ProductoDTO dto) {
        return new Producto(
                dto.getId(),
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getCantidad(),
                dto.getPrecio()
        );
    }

    public static List<ProductoDTO> toDTOList(List<Producto> productos) {
        return productos.stream().map(ProductoAssembler::toDTO).collect(Collectors.toList());
    }
}
