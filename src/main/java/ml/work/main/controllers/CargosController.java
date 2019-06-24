package ml.work.main.controllers;

import java.util.List;

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

import ml.work.main.dtos.CargosDTO;
import ml.work.main.service.CargosService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "api/v1/cargos")
public class CargosController implements ObjectController<CargosDTO>{
	
	private CargosService cargosService;

	public CargosController(CargosService cargosService) {
		this.cargosService = cargosService;
	}
	
	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/")
	public List<CargosDTO> getAll() {
		return ResponseEntity.status(200).body(cargosService.getAll()).getBody();
	}
	
	
	@Override
	@GetMapping(path = "/{id}")
	public CargosDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(cargosService.getOne(id)).getBody();
	}
	
	
	@Override
	@PostMapping("/")
	public ResponseEntity save(@RequestBody CargosDTO body) {
		CargosDTO temp = cargosService.save(body);

		if (temp.getId_cargo() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
	}
	
	@Override
	@PutMapping("/{id}")
	public ResponseEntity updateEntity(@RequestBody CargosDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(cargosService.update(t, id));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEntity(@PathVariable int id) {
		boolean det = cargosService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Successful Delete'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Unsuccessful delete'");
		}
	}
}
