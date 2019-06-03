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

import isi.aepad.tpintegrador.domain.DetalleOrdenDeCompra;
import isi.aepad.tpintegrador.service.DetalleOrdenDeCompraService;

@RestController
@RequestMapping("api/detalleOrdenDeCompra")
public class DetalleOrdenDeCompraRest {

	@Autowired
	DetalleOrdenDeCompraService detalleOrdenDeCompraService;
	
	@GetMapping("buscar")
	public ResponseEntity<List<DetalleOrdenDeCompra>> buscar() {
		return  new ResponseEntity<List<DetalleOrdenDeCompra>>(this.detalleOrdenDeCompraService.buscarTodas(), HttpStatus.OK);
	}
	
	@GetMapping("buscar/{id}")
	public ResponseEntity<DetalleOrdenDeCompra> buscar(@RequestParam(value="id") Integer idDetalleOrdenDeCompra) {
		return  new ResponseEntity<DetalleOrdenDeCompra>(this.detalleOrdenDeCompraService.buscarPorId(idDetalleOrdenDeCompra), HttpStatus.OK);
	}
	
	@PostMapping("crear")
	public ResponseEntity<DetalleOrdenDeCompra> crear(@RequestBody DetalleOrdenDeCompra p,UriComponentsBuilder builder) {
        DetalleOrdenDeCompra creado = this.detalleOrdenDeCompraService.guardar(p);
        if (creado == null) {
        	return new ResponseEntity<DetalleOrdenDeCompra>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/detalleOrdenDeCompra/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<DetalleOrdenDeCompra>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("actualizar")
	public ResponseEntity<DetalleOrdenDeCompra> actualizar(@RequestBody DetalleOrdenDeCompra p,UriComponentsBuilder builder) {
		DetalleOrdenDeCompra actualizar = this.detalleOrdenDeCompraService.guardar(p);
        return new ResponseEntity<DetalleOrdenDeCompra>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("borrar/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") Integer idDetalleOrdenDeCompra) {
        this.detalleOrdenDeCompraService.borrar(idDetalleOrdenDeCompra);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
