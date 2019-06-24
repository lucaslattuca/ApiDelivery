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

import ml.work.main.dtos.EmpleadoDTO;
import ml.work.main.service.EmpleadoService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "api/v1/empleados")
public class EmpleadoController implements ObjectController<EmpleadoDTO>{

	private EmpleadoService empleadoService;

	public EmpleadoController(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}
	
	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/")
	public List<EmpleadoDTO> getAll() {
		return ResponseEntity.status(200).body(empleadoService.getAll()).getBody();
	}
	
	
	@Override
	@GetMapping(path = "/{id}")
	public EmpleadoDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(empleadoService.getOne(id)).getBody();
	}
	
	
	@Override
	@PostMapping("/")
	public ResponseEntity save(@RequestBody EmpleadoDTO body) {
		EmpleadoDTO temp = empleadoService.save(body);

		if (temp.getId_empleado() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
	}
	
	@Override
	@PutMapping("/{id}")
	public ResponseEntity updateEntity(@RequestBody EmpleadoDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(empleadoService.update(t, id));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEntity(@PathVariable int id) {
		boolean det = empleadoService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Successful Delete'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Unsuccessful delete'");
		}
	}

	
}
