package isi.aepad.tpintegrador.service;

import java.util.List;

import isi.aepad.tpintegrador.domain.OrdenDeCompra;

public interface OrdenDeCompraService {

	public OrdenDeCompra guardar(OrdenDeCompra t);
	
	public void borrar(Integer id);
	
	public List<OrdenDeCompra> buscarTodas();
	
	public OrdenDeCompra buscarPorId(Integer id);
}
