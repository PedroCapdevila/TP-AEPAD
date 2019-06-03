package isi.aepad.tpintegrador.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tpintegrador.domain.Usuario;
import isi.aepad.tpintegrador.repository.UsuarioRepository;
import isi.aepad.tpintegrador.service.UsuarioService;

@Service
public class UsuarioServiceDefault implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Override
	public Usuario buscarPorId(Integer id) {
		return usuarioRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el usuario con ID "+id));

	}

	@Override
	public Usuario guardar(Usuario t) {
		return usuarioRepo.save(t);
	}

	@Override
	public void borrar(Integer id) {
		usuarioRepo.deleteById(id);
	}

	@Override
	public List<Usuario> buscarTodas() {
		return usuarioRepo.findAll();
	}

}
