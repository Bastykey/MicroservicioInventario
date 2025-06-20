package cl.duoc.MicroservicioInventario.Repository;

import cl.duoc.MicroservicioInventario.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositoy  extends JpaRepository<Producto, Long> {
}
