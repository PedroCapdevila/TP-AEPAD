package isi.aepad.tpintegrador.ACDZ.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.aepad.tpintegrador.ACDZ.apptest.domain.Producto;

public interface ProductRepository extends JpaRepository<Producto, Integer> {

}
