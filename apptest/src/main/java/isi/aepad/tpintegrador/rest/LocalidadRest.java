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

import isi.aepad.tpintegrador.domain.Localidad;
import isi.aepad.tpintegrador.service.LocalidadService;

@RestController
@RequestMapping("api/localidad")
public class LocalidadRest {

	@Autowired
	LocalidadService localidadService;
	
	@GetMapping("buscar")
	public ResponseEntity<List<Localidad>> buscar() {
		return  new ResponseEntity<List<Localidad>>(this.localidadService.buscarTodas(), HttpStatus.OK);
	}
	
	@GetMapping("buscar/{id}")
	public ResponseEntity<Localidad> buscar(@RequestParam(value="id") Integer idLocalidad) {
		return  new ResponseEntity<Localidad>(this.localidadService.buscarPorId(idLocalidad), HttpStatus.OK);
	}
	
	@PostMapping("crear")
	public ResponseEntity<Localidad> crear(@RequestBody Localidad p,UriComponentsBuilder builder) {
        Localidad creado = this.localidadService.guardar(p);
        if (creado == null) {
        	return new ResponseEntity<Localidad>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/localidad/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Localidad>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("actualizar")
	public ResponseEntity<Localidad> actualizar(@RequestBody Localidad p,UriComponentsBuilder builder) {
		Localidad actualizar = this.localidadService.guardar(p);
        return new ResponseEntity<Localidad>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("borrar/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") Integer idLocalidad) {
        this.localidadService.borrar(idLocalidad);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
