package isi.aepad.tpintegrador.service;

import java.util.List;

import isi.aepad.tpintegrador.domain.Usuario;

public interface UsuarioService {

	public Usuario guardar(Usuario t);
	
	public void borrar(Integer id);
	
	public List<Usuario> buscarTodas();
	
	public Usuario buscarPorId(Integer id);
}
