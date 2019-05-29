package isi.aepad.tpintegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import isi.aepad.tpintegrador.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
