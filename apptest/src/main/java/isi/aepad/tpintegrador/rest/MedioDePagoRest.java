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

import isi.aepad.tpintegrador.domain.MedioDePago;
import isi.aepad.tpintegrador.service.MedioDePagoService;

@RestController
@RequestMapping("api/medioDePago")
public class MedioDePagoRest {

	@Autowired
	MedioDePagoService medioDePagoService;
	
	@GetMapping("buscar")
	public ResponseEntity<List<MedioDePago>> buscar() {
		return  new ResponseEntity<List<MedioDePago>>(this.medioDePagoService.buscarTodas(), HttpStatus.OK);
	}
	
	@GetMapping("buscar/{id}")
	public ResponseEntity<MedioDePago> buscar(@RequestParam(value="id") Integer idMedioDePago) {
		return  new ResponseEntity<MedioDePago>(this.medioDePagoService.buscarPorId(idMedioDePago), HttpStatus.OK);
	}
	
	@PostMapping("crear")
	public ResponseEntity<MedioDePago> crear(@RequestBody MedioDePago p,UriComponentsBuilder builder) {
        MedioDePago creado = this.medioDePagoService.guardar(p);
        if (creado == null) {
        	return new ResponseEntity<MedioDePago>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/medioDePago/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<MedioDePago>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("actualizar")
	public ResponseEntity<MedioDePago> actualizar(@RequestBody MedioDePago p,UriComponentsBuilder builder) {
		MedioDePago actualizar = this.medioDePagoService.guardar(p);
        return new ResponseEntity<MedioDePago>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("borrar/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") Integer idMedioDePago) {
        this.medioDePagoService.borrar(idMedioDePago);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
