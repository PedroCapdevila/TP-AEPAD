package isi.aepad.tpintegrador.service;

import java.util.List;

import isi.aepad.tpintegrador.domain.Cliente;

public interface ClienteService {

	public Cliente guardar(Cliente t);
	
	public void borrar(Integer id);
	
	public List<Cliente> buscarTodas();
	
	public Cliente buscarPorId(Integer id);
}
