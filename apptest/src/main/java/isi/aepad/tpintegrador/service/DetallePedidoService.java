package isi.aepad.tpintegrador.service;

import java.util.List;

import isi.aepad.tpintegrador.domain.DetallePedido;

public interface DetallePedidoService {

	public DetallePedido guardar(DetallePedido t);
	
	public void borrar(Integer id);
	
	public List<DetallePedido> buscarTodas();
	
	public DetallePedido buscarPorId(Integer id);
}
