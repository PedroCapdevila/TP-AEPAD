package isi.aepad.tpintegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import isi.aepad.tpintegrador.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
