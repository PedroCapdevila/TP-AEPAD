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

import isi.aepad.tpintegrador.domain.OrdenDeCompra;
import isi.aepad.tpintegrador.service.OrdenDeCompraService;

@RestController
@RequestMapping("api/ordenDeCompra")
public class OrdenDeCompraRest {

	@Autowired
	OrdenDeCompraService ordenDeCompraService;
	
	@GetMapping("buscar")
	public ResponseEntity<List<OrdenDeCompra>> buscar() {
		return  new ResponseEntity<List<OrdenDeCompra>>(this.ordenDeCompraService.buscarTodas(), HttpStatus.OK);
	}
	
	@GetMapping("buscar/{id}")
	public ResponseEntity<OrdenDeCompra> buscar(@RequestParam(value="id") Integer idOrdenDeCompra) {
		return  new ResponseEntity<OrdenDeCompra>(this.ordenDeCompraService.buscarPorId(idOrdenDeCompra), HttpStatus.OK);
	}
	
	@PostMapping("crear")
	public ResponseEntity<OrdenDeCompra> crear(@RequestBody OrdenDeCompra p,UriComponentsBuilder builder) {
        OrdenDeCompra creado = this.ordenDeCompraService.guardar(p);
        if (creado == null) {
        	return new ResponseEntity<OrdenDeCompra>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/ordenDeCompra/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<OrdenDeCompra>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("actualizar")
	public ResponseEntity<OrdenDeCompra> actualizar(@RequestBody OrdenDeCompra p,UriComponentsBuilder builder) {
		OrdenDeCompra actualizar = this.ordenDeCompraService.guardar(p);
        return new ResponseEntity<OrdenDeCompra>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("borrar/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") Integer idOrdenDeCompra) {
        this.ordenDeCompraService.borrar(idOrdenDeCompra);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
