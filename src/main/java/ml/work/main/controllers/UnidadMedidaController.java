package ml.work.main.controllers;

import java.util.List;

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

import ml.work.main.dtos.UnidadMedidaDTO;
import ml.work.main.service.UnidadMedidaService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "/api/v1/medidas")
public class UnidadMedidaController implements ObjectController<UnidadMedidaDTO>{

	private UnidadMedidaService unidadMedidaService;

	public UnidadMedidaController(UnidadMedidaService unidadMedidaService) {
		this.unidadMedidaService = unidadMedidaService;
	}
	
	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/lista")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<UnidadMedidaDTO>> getAll(){
        List<UnidadMedidaDTO> lista = unidadMedidaService.getAll();
        return new ResponseEntity<List<UnidadMedidaDTO>>(lista, HttpStatus.OK);
    }

	@Override
	@GetMapping(path = "/detalle/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<UnidadMedidaDTO> getOne(@PathVariable int id) {
		UnidadMedidaDTO medida = unidadMedidaService.getOne(id);
	    return new ResponseEntity<UnidadMedidaDTO>(medida, HttpStatus.OK);
	}

	@Override
	@PostMapping("nuevo")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity save(@RequestBody UnidadMedidaDTO body) {
		UnidadMedidaDTO temp = unidadMedidaService.save(body);

		if (temp.getId_medida() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
	}

	@Override
	@PutMapping("/actualizar/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity update(@RequestBody UnidadMedidaDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(unidadMedidaService.update(t, id));
	}

	@Override
	@DeleteMapping("/borrar/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = unidadMedidaService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Successful Delete'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Unsuccessful delete'");
		}
	}
}
