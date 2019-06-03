package isi.aepad.tpintegrador.rest;

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

import java.util.List;

import isi.aepad.tpintegrador.domain.Producto;
import isi.aepad.tpintegrador.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoRest {
	
	@Autowired
	ProductoService productoService;
	
	@PostMapping("crear")
	public ResponseEntity<Producto> crear(@RequestBody Producto p,UriComponentsBuilder builder) {
		Producto creado = this.productoService.guardar(p);
        if (creado == null) {
        	return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/producto/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Producto>(creado,headers, HttpStatus.CREATED);
	}
	
	@GetMapping("buscar")
	public ResponseEntity<List<Producto>> buscar(){
		return  new ResponseEntity<List<Producto>>(this.productoService.buscarTodas(),HttpStatus.OK);
	}
	
	@GetMapping("buscar/{id}")
	public ResponseEntity<Producto> buscar(@RequestParam(value="id") Integer idProducto) {
		return  new ResponseEntity<Producto>(this.productoService.buscarPorId(idProducto), HttpStatus.OK);
	}
		
	@PutMapping("actualizar")
	public ResponseEntity<Producto> actualizar(@RequestBody Producto p,UriComponentsBuilder builder) {
		Producto actualizar = this.productoService.guardar(p);
        return new ResponseEntity<Producto>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("borrar/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") Integer idProducto) {
        this.productoService.borrar(idProducto);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
