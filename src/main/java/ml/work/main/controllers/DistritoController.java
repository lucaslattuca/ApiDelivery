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

import ml.work.main.dtos.ClienteDTO;
import ml.work.main.dtos.DistritoDTO;
import ml.work.main.service.DistritoService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "api/v1/Distritos")
public class DistritoController implements ObjectController<DistritoDTO>{

	private DistritoService distritoService;
	
	public DistritoController(DistritoService distritoService) {
		this.distritoService = distritoService;
	}

	@Override
	@CrossOrigin("*")
	@GetMapping(path ="/")
	public List<DistritoDTO> getAll() {
		
		return ResponseEntity.status(200).body(distritoService.getAll()).getBody();
	}

	@Override
	@GetMapping("/{id}")
	public DistritoDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(distritoService.getOne(id)).getBody();
	}

	@Override
	@PostMapping("/")
	public ResponseEntity save(@RequestBody DistritoDTO t) {
		DistritoDTO temp = distritoService.save(t);
		
		if (temp.getId_Distrito() != 0) {
			return ResponseEntity.status(201).body(temp);
		}else {
			return ResponseEntity.status(400).body("{error : 'bad request'}");
		}
		
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity updateEntity(@RequestBody DistritoDTO t, @PathVariable int id) {
		
		return ResponseEntity.status(201).body(distritoService.update(t, id));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEntity(@PathVariable int id) {
		boolean det = distritoService.delete(id);
		if (det) {
			return ResponseEntity.status(204).body("");
		}else {
			return ResponseEntity.status(400).body("");
		}
	}

}
