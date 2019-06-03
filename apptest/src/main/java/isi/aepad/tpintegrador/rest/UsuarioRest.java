package isi.aepad.tpintegrador.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import isi.aepad.tpintegrador.domain.Usuario;
import isi.aepad.tpintegrador.service.UsuarioService;

@RestController
@RequestMapping("api/usuario")
public class UsuarioRest {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("buscar")
	public ResponseEntity<List<Usuario>> buscar() {
		return  new ResponseEntity<List<Usuario>>(this.usuarioService.buscarTodas(), HttpStatus.OK);
	}
	
	@GetMapping("buscar/{id}")
	public ResponseEntity<Usuario> buscar(@RequestParam(value="id") Integer idUsuario) {
		return  new ResponseEntity<Usuario>(this.usuarioService.buscarPorId(idUsuario), HttpStatus.OK);
	}
	
	@PostMapping("crear")
	public ResponseEntity<Usuario> crear(@RequestBody Usuario p,UriComponentsBuilder builder) {
        Usuario creado = this.usuarioService.guardar(p);
        if (creado == null) {
        	return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/usuario/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Usuario>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("actualizar")
	public ResponseEntity<Usuario> actualizar(@RequestBody Usuario p,UriComponentsBuilder builder) {
		Usuario actualizar = this.usuarioService.guardar(p);
        return new ResponseEntity<Usuario>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("borrar/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") Integer idUsuario) {
        this.usuarioService.borrar(idUsuario);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
