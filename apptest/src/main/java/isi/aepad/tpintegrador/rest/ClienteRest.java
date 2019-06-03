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

import isi.aepad.tpintegrador.domain.Cliente;
import isi.aepad.tpintegrador.service.ClienteService;

@RestController
@RequestMapping("api/cliente")
public class ClienteRest {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping("buscar")
	public ResponseEntity<List<Cliente>> buscar() {
		return  new ResponseEntity<List<Cliente>>(this.clienteService.buscarTodas(), HttpStatus.OK);
	}
	
	@GetMapping("buscar/{id}")
	public ResponseEntity<Cliente> buscar(@RequestParam(value="id") Integer idCliente) {
		return  new ResponseEntity<Cliente>(this.clienteService.buscarPorId(idCliente), HttpStatus.OK);
	}
	
	@PostMapping("crear")
	public ResponseEntity<Cliente> crear(@RequestBody Cliente p,UriComponentsBuilder builder) {
        Cliente creado = this.clienteService.guardar(p);
        if (creado == null) {
        	return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/cliente/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Cliente>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("actualizar")
	public ResponseEntity<Cliente> actualizar(@RequestBody Cliente p,UriComponentsBuilder builder) {
		Cliente actualizar = this.clienteService.guardar(p);
        return new ResponseEntity<Cliente>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("borrar/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") Integer idCliente) {
        this.clienteService.borrar(idCliente);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
