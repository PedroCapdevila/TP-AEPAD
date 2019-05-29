package isi.aepad.tpintegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import isi.aepad.tpintegrador.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
