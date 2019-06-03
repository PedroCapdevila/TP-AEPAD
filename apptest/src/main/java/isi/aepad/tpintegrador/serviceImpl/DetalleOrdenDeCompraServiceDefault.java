package isi.aepad.tpintegrador.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tpintegrador.domain.DetalleOrdenDeCompra;
import isi.aepad.tpintegrador.repository.DetalleOrdenDeCompraRepository;
import isi.aepad.tpintegrador.service.DetalleOrdenDeCompraService;

@Service
public class DetalleOrdenDeCompraServiceDefault implements DetalleOrdenDeCompraService{

	@Autowired
	private DetalleOrdenDeCompraRepository detalleOrdenDeCompraRepo;
	
	@Override
	public DetalleOrdenDeCompra buscarPorId(Integer id) {
		return detalleOrdenDeCompraRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el detalleOrdenDeCompra con ID "+id));

	}

	@Override
	public DetalleOrdenDeCompra guardar(DetalleOrdenDeCompra t) {
		return detalleOrdenDeCompraRepo.save(t);
	}

	@Override
	public void borrar(Integer id) {
		detalleOrdenDeCompraRepo.deleteById(id);
	}

	@Override
	public List<DetalleOrdenDeCompra> buscarTodas() {
		return detalleOrdenDeCompraRepo.findAll();
	}
}
