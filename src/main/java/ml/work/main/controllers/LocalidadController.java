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

import ml.work.main.dtos.LocalidadDTO;
import ml.work.main.service.LocalidadService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "api/v1/localidades")
public class LocalidadController implements ObjectController<LocalidadDTO>{

	private LocalidadService localidadService;
	
	public LocalidadController(LocalidadService localidadService) {
		this.localidadService = localidadService;
	}

	@Override
	@CrossOrigin("*")
	@GetMapping(path ="/")
	public List<LocalidadDTO> getAll() {		
		return ResponseEntity.status(200).body(localidadService.getAll()).getBody();
	}

	@Override
	@GetMapping("/{id}")
	public LocalidadDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(localidadService.getOne(id)).getBody();
	}

	@Override
	@PostMapping("/")
	public ResponseEntity save(@RequestBody LocalidadDTO t) {
		LocalidadDTO temp = localidadService.save(t);
		
		if (temp.getId_Localidad() != 0) {
			return ResponseEntity.status(201).body(temp);
		}else {
			return ResponseEntity.status(400).body("{error : 'bad request'}");
		}
		
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity updateEntity(@RequestBody LocalidadDTO t, @PathVariable int id) {
		
		return ResponseEntity.status(201).body(localidadService.update(t, id));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEntity(@PathVariable int id) {
		boolean det = localidadService.delete(id);
		if (det) {
			return ResponseEntity.status(204).body("");
		}else {
			return ResponseEntity.status(400).body("");
		}
	}


}
