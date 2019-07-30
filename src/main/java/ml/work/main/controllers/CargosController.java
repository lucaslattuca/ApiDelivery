package ml.work.main.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
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
import ml.work.main.dtos.CargosDTO;
import ml.work.main.service.CargosService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "/api/v1/cargos")
public class CargosController implements ObjectController<CargosDTO>{
	
	private CargosService cargosService;

	public CargosController(CargosService cargosService) {
		this.cargosService = cargosService;
	}
	
	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/lista")
	public ResponseEntity <List<CargosDTO>> getAll() {
		 List<CargosDTO> cargos = cargosService.getAll();
		 return new ResponseEntity<List<CargosDTO>>(cargos, HttpStatus.OK);
	}
	
	
	@Override
	@GetMapping(path = "/detalle/{id}")
	public ResponseEntity<CargosDTO> getOne(@PathVariable int id) {
		CargosDTO cargos = cargosService.getOne(id);
		return new ResponseEntity<CargosDTO>(cargos, HttpStatus.OK);
	}
	
	
	@Override
	@PostMapping("nuevo")
	public ResponseEntity save(@RequestBody CargosDTO body) {
		CargosDTO temp = cargosService.save(body);

		if (temp.getId_cargo() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
	}
	
	@Override
	@PutMapping("/actiualizar/{id}")
	public ResponseEntity update(@RequestBody CargosDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(cargosService.update(t, id));
	}

	@Override
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = cargosService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Successful Delete'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Unsuccessful delete'");
		}
	}
}
