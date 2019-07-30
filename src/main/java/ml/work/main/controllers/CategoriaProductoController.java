package ml.work.main.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ml.work.main.dtos.CategoriaProductoDTO;
import ml.work.main.service.CategoriaProductoService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "/api/v1/categorias")
public class CategoriaProductoController implements ObjectController<CategoriaProductoDTO>{
	
	private CategoriaProductoService categoriaProductoService;

	public CategoriaProductoController(CategoriaProductoService categoriaProductoService) {
		this.categoriaProductoService = categoriaProductoService;
	}

	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/lista")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<CategoriaProductoDTO>> getAll(){
        List<CategoriaProductoDTO> lista = categoriaProductoService.getAll();
        return new ResponseEntity<List<CategoriaProductoDTO>>(lista, HttpStatus.OK);
    }
	
	@Override
	@CrossOrigin("*")	
	@GetMapping("/detalle/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<CategoriaProductoDTO> getOne(@PathVariable int id){
	     CategoriaProductoDTO uno = categoriaProductoService.getOne(id);
	    return new ResponseEntity<CategoriaProductoDTO>(uno, HttpStatus.OK);
	}

	@Override
	@PostMapping("nuevo")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity save(@RequestBody CategoriaProductoDTO body) {
		CategoriaProductoDTO temp = categoriaProductoService.save(body);

		if (temp.getId_categoria() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
	}

	@Override
	@PutMapping("/actualizar/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity update(@RequestBody CategoriaProductoDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(categoriaProductoService.update(t, id));
	}

	@Override
	@DeleteMapping("/borrar/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = categoriaProductoService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Successful Delete'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Unsuccessful delete'");
		}
	}

}
