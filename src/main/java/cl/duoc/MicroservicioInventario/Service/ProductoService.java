package cl.duoc.MicroservicioInventario.Service;

import cl.duoc.MicroservicioInventario.Model.Producto;
import cl.duoc.MicroservicioInventario.Repository.ProductoRepositoy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepositoy repository;

    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    public Producto obtenerPorId(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Producto no encontrado"));
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public void eliminar(Long id) throws Exception {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new Exception("No se puede eliminar un producto inexistente");
        }
    }
}