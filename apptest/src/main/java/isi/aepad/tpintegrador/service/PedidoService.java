package isi.aepad.tpintegrador.service;

import java.util.List;

import isi.aepad.tpintegrador.domain.Pedido;

public interface PedidoService {

	public Pedido guardar(Pedido t);
	
	public void borrar(Integer id);
	
	public List<Pedido> buscarTodas();
	
	public Pedido buscarPorId(Integer id);
}
