package isi.aepad.tpintegrador.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tpintegrador.domain.DetallePedido;
import isi.aepad.tpintegrador.repository.DetallePedidoRepository;
import isi.aepad.tpintegrador.service.DetallePedidoService;

@Service
public class DetallePedidoServiceDefault implements DetallePedidoService{

	@Autowired
	private DetallePedidoRepository detallePedidoRepo;
	
	@Override
	public DetallePedido buscarPorId(Integer id) {
		return detallePedidoRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el detallePedido con ID "+id));

	}

	@Override
	public DetallePedido guardar(DetallePedido t) {
		return detallePedidoRepo.save(t);
	}

	@Override
	public void borrar(Integer id) {
		detallePedidoRepo.deleteById(id);
	}

	@Override
	public List<DetallePedido> buscarTodas() {
		return detallePedidoRepo.findAll();
	}
}
