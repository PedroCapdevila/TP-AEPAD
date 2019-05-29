package isi.aepad.tpintegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import isi.aepad.tpintegrador.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
