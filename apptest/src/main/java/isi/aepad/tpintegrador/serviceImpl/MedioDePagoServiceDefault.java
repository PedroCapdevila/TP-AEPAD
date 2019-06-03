package isi.aepad.tpintegrador.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tpintegrador.domain.MedioDePago;
import isi.aepad.tpintegrador.repository.MedioDePagoRepository;
import isi.aepad.tpintegrador.service.MedioDePagoService;

@Service
public class MedioDePagoServiceDefault implements MedioDePagoService{

	@Autowired
	private MedioDePagoRepository medioDePagoRepo;
	
	@Override
	public MedioDePago buscarPorId(Integer id) {
		return medioDePagoRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el medioDePago con ID "+id));

	}

	@Override
	public MedioDePago guardar(MedioDePago t) {
		return medioDePagoRepo.save(t);
	}

	@Override
	public void borrar(Integer id) {
		medioDePagoRepo.deleteById(id);
	}

	@Override
	public List<MedioDePago> buscarTodas() {
		return medioDePagoRepo.findAll();
	}

}
