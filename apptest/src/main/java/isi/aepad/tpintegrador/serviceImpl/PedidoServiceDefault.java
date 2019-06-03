package isi.aepad.tpintegrador.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tpintegrador.domain.Pedido;
import isi.aepad.tpintegrador.repository.PedidoRepository;
import isi.aepad.tpintegrador.service.PedidoService;

@Service
public class PedidoServiceDefault implements PedidoService{

	@Autowired
	private PedidoRepository pedidoRepo;
	
	@Override
	public Pedido buscarPorId(Integer id) {
		return pedidoRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el pedido con ID "+id));

	}

	@Override
	public Pedido guardar(Pedido t) {
		return pedidoRepo.save(t);
	}

	@Override
	public void borrar(Integer id) {
		pedidoRepo.deleteById(id);
	}

	@Override
	public List<Pedido> buscarTodas() {
		return pedidoRepo.findAll();
	}

}
