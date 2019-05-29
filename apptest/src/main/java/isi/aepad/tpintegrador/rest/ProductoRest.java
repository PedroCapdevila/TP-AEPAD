package isi.aepad.tpintegrador.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import isi.aepad.tpintegrador.domain.Producto;
import isi.aepad.tpintegrador.repository.ProductoRepository;

@RestController
@RequestMapping("api/producto")
public class ProductoRest {
	
	@Autowired
	ProductoRepository prdRepo;
	
	@GetMapping("crear")
	public ResponseEntity<Void> crear(){
		Producto p = new Producto();
		p.setNombre("Producto 1"+ System.currentTimeMillis());
		prdRepo.save(p);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("buscar")
	public ResponseEntity<List<Producto>> buscar(){
		return  new ResponseEntity<List<Producto>>(this.prdRepo.findAll(),HttpStatus.OK);
	}
}
