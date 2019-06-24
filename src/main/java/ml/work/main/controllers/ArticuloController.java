package ml.work.main.controllers;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
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

import ml.work.main.dtos.ArticuloDTO;
import ml.work.main.service.ArticuloService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "api/v1/articulos")
public class ArticuloController implements ObjectController<ArticuloDTO>{

	private ArticuloService articuloService;

	public ArticuloController(ArticuloService articuloService) {
		this.articuloService = articuloService;
	}

	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/")
	public ArrayList<ArticuloDTO> getAll() {
		return ResponseEntity.status(200).body(articuloService.getAll()).getBody();
	}
	
	
	@GetMapping(path = "/primas/{buscar}")
	public ArrayList<ArticuloDTO> getInsumoEnLista(@PathVariable boolean buscar) {
		return ResponseEntity.status(200).body(articuloService.getInsumoEnLista(buscar)).getBody();
	}
	
	
	@GetMapping(path = "/vendibles/{buscar}")
	public ArrayList<ArticuloDTO> getVendibleEnLista(@PathVariable boolean buscar) {
		return ResponseEntity.status(200).body(articuloService.getVendibleEnLista(buscar)).getBody();
	}

	@Override
	@GetMapping(path = "/{id}")
	public ArticuloDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(articuloService.getOne(id)).getBody();
	}
	
	@Override
	@PostMapping("/")
	public ResponseEntity save(@RequestBody ArticuloDTO body) {
		ArticuloDTO temp = articuloService.save(body);

		if (temp.getId_articulo() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
	}
	
	@Override
	@PutMapping("/{id}")
	public ResponseEntity updateEntity(@RequestBody ArticuloDTO t,@PathVariable  int id) {
		return ResponseEntity.status(201).body(articuloService.update(t, id));
	}
	
	
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEntity(@PathVariable int id) {
		boolean det = articuloService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Successful Delete'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Unsuccessful delete'");
		}
	}

}
