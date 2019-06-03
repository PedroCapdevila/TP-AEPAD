package isi.aepad.tpintegrador.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tpintegrador.domain.Cliente;
import isi.aepad.tpintegrador.repository.ClienteRepository;
import isi.aepad.tpintegrador.service.ClienteService;

@Service
public class ClienteServiceDefault implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepo;
	
	@Override
	public Cliente buscarPorId(Integer id) {
		return clienteRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));

	}

	@Override
	public Cliente guardar(Cliente t) {
		return clienteRepo.save(t);
	}

	@Override
	public void borrar(Integer id) {
		clienteRepo.deleteById(id);
	}

	@Override
	public List<Cliente> buscarTodas() {
		return clienteRepo.findAll();
	}
}
