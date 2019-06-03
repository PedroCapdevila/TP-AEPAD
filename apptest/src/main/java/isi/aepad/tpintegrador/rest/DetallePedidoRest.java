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

import isi.aepad.tpintegrador.domain.DetallePedido;
import isi.aepad.tpintegrador.service.DetallePedidoService;

@RestController
@RequestMapping("api/detallePedido")
public class DetallePedidoRest {

	@Autowired
	DetallePedidoService detallePedidoService;
	
	@GetMapping("buscar")
	public ResponseEntity<List<DetallePedido>> buscar() {
		return  new ResponseEntity<List<DetallePedido>>(this.detallePedidoService.buscarTodas(), HttpStatus.OK);
	}
	
	@GetMapping("buscar/{id}")
	public ResponseEntity<DetallePedido> buscar(@RequestParam(value="id") Integer idDetallePedido) {
		return  new ResponseEntity<DetallePedido>(this.detallePedidoService.buscarPorId(idDetallePedido), HttpStatus.OK);
	}
	
	@PostMapping("crear")
	public ResponseEntity<DetallePedido> crear(@RequestBody DetallePedido p,UriComponentsBuilder builder) {
        DetallePedido creado = this.detallePedidoService.guardar(p);
        if (creado == null) {
        	return new ResponseEntity<DetallePedido>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/detallePedido/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<DetallePedido>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("actualizar")
	public ResponseEntity<DetallePedido> actualizar(@RequestBody DetallePedido p,UriComponentsBuilder builder) {
		DetallePedido actualizar = this.detallePedidoService.guardar(p);
        return new ResponseEntity<DetallePedido>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("borrar/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") Integer idDetallePedido) {
        this.detallePedidoService.borrar(idDetallePedido);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
