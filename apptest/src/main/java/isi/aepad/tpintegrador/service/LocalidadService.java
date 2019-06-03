package isi.aepad.tpintegrador.service;

import java.util.List;

import isi.aepad.tpintegrador.domain.Localidad;

public interface LocalidadService {

	public Localidad guardar(Localidad t);
	
	public void borrar(Integer id);
	
	public List<Localidad> buscarTodas();
	
	public Localidad buscarPorId(Integer id);
}
