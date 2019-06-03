package isi.aepad.tpintegrador.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tpintegrador.domain.Producto;
import isi.aepad.tpintegrador.repository.ProductoRepository;
import isi.aepad.tpintegrador.service.ProductoService;

@Service
public class ProductoServiceDefault implements ProductoService{

	@Autowired
	private ProductoRepository productoRepo;
	
	@Override
	public Producto buscarPorId(Integer id) {
		return productoRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto con ID "+id));

	}

	@Override
	public Producto guardar(Producto t) {
		return productoRepo.save(t);
	}

	@Override
	public void borrar(Integer id) {
		productoRepo.deleteById(id);
	}

	@Override
	public List<Producto> buscarTodas() {
		return productoRepo.findAll();
	}
	
}
