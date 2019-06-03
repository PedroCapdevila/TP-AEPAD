package isi.aepad.tpintegrador.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tpintegrador.domain.OrdenDeCompra;
import isi.aepad.tpintegrador.repository.OrdenDeCompraRepository;
import isi.aepad.tpintegrador.service.OrdenDeCompraService;

@Service
public class OrdenDeCompraServiceDefault implements OrdenDeCompraService{

	@Autowired
	private OrdenDeCompraRepository ordenDeCompraRepo;
	
	@Override
	public OrdenDeCompra buscarPorId(Integer id) {
		return ordenDeCompraRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el ordenDeCompra con ID "+id));

	}

	@Override
	public OrdenDeCompra guardar(OrdenDeCompra t) {
		return ordenDeCompraRepo.save(t);
	}

	@Override
	public void borrar(Integer id) {
		ordenDeCompraRepo.deleteById(id);
	}

	@Override
	public List<OrdenDeCompra> buscarTodas() {
		return ordenDeCompraRepo.findAll();
	}

}
