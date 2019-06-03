package isi.aepad.tpintegrador.service;

import java.util.List;

import isi.aepad.tpintegrador.domain.DetalleOrdenDeCompra;

public interface DetalleOrdenDeCompraService {
	
	public DetalleOrdenDeCompra guardar(DetalleOrdenDeCompra t);
	
	public void borrar(Integer id);
	
	public List<DetalleOrdenDeCompra> buscarTodas();
	
	public DetalleOrdenDeCompra buscarPorId(Integer id);
}
