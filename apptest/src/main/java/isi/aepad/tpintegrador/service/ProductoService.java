package isi.aepad.tpintegrador.service;

import java.util.List;

import isi.aepad.tpintegrador.domain.Producto;

public interface ProductoService {

	public Producto guardar(Producto t);
	
	public void borrar(Integer id);
	
	public List<Producto> buscarTodas();
	
	public Producto buscarPorId(Integer id);
}
