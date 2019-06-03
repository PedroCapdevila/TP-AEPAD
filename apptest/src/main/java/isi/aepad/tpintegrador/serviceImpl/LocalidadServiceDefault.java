package isi.aepad.tpintegrador.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tpintegrador.domain.Localidad;
import isi.aepad.tpintegrador.repository.LocalidadRepository;
import isi.aepad.tpintegrador.service.LocalidadService;

@Service
public class LocalidadServiceDefault implements LocalidadService{

	@Autowired
	private LocalidadRepository localidadRepo;
	
	@Override
	public Localidad buscarPorId(Integer id) {
		return localidadRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el localidad con ID "+id));

	}

	@Override
	public Localidad guardar(Localidad t) {
		return localidadRepo.save(t);
	}

	@Override
	public void borrar(Integer id) {
		localidadRepo.deleteById(id);
	}

	@Override
	public List<Localidad> buscarTodas() {
		return localidadRepo.findAll();
	}
}
