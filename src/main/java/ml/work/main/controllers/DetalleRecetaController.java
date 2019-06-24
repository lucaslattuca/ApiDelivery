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

import ml.work.main.dtos.DetalleRecetaDTO;
import ml.work.main.service.DetalleRecetaService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "api/v1/recetas")
public class DetalleRecetaController implements ObjectController<DetalleRecetaDTO>{

	private DetalleRecetaService detalleRecetaService;

	public DetalleRecetaController(DetalleRecetaService detalleRecetaService) {
		this.detalleRecetaService = detalleRecetaService;
	}
	
	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/")
	public ArrayList<DetalleRecetaDTO> getAll() {
		return ResponseEntity.status(200).body(detalleRecetaService.getAll()).getBody();
	}

	@Override
	@GetMapping(path = "/{id}")
	public DetalleRecetaDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(detalleRecetaService.getOne(id)).getBody();
	}

	@Override
	@PostMapping("/")
	public ResponseEntity save(@RequestBody DetalleRecetaDTO body) {
		DetalleRecetaDTO temp = detalleRecetaService.save(body);

		if (temp.getId_receta() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity updateEntity(@RequestBody DetalleRecetaDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(detalleRecetaService.update(t, id));
	}
	
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEntity(@PathVariable int id) {
		boolean det = detalleRecetaService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Successful Delete'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Unsuccessful delete'");
		}
	}

}
