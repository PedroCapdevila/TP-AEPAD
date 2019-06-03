package isi.aepad.tpintegrador.service;

import java.util.List;

import isi.aepad.tpintegrador.domain.MedioDePago;

public interface MedioDePagoService {

	public MedioDePago guardar(MedioDePago t);
	
	public void borrar(Integer id);
	
	public List<MedioDePago> buscarTodas();
	
	public MedioDePago buscarPorId(Integer id);
}
