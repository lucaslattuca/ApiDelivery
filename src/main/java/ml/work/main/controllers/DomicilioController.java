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

import ml.work.main.dtos.DomicilioDTO;
import ml.work.main.dtos.EmpleadoDTO;
import ml.work.main.service.DomicilioService;
@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "/api/v1/domicilios")
public class DomicilioController implements ObjectController<DomicilioDTO>{

	private DomicilioService domicilioService;
	
	
	public DomicilioController(DomicilioService domicilioService) {
		this.domicilioService = domicilioService;
	}

	@Override
	@CrossOrigin("*")
	@GetMapping(path ="/lista")
	public ResponseEntity<List<DomicilioDTO>> getAll(){
        List<DomicilioDTO> lista = domicilioService.getAll();
        return new ResponseEntity<List<DomicilioDTO>>(lista, HttpStatus.OK);
    }

	@Override
	@GetMapping("/detalle/{id}")
	public ResponseEntity<DomicilioDTO> getOne(@PathVariable int id){
		DomicilioDTO uno = domicilioService.getOne(id);
	    return new ResponseEntity<DomicilioDTO>(uno, HttpStatus.OK);
	}

	@Override
	@PostMapping("nuevo")
	public ResponseEntity save(@RequestBody DomicilioDTO t) {
		DomicilioDTO temp = domicilioService.save(t);
		
		if (temp.getId_domicilio() != 0) {
			return ResponseEntity.status(201).body(temp);
		}else {
			return ResponseEntity.status(400).body("{error : 'bad request'}");
		}
		
	}

	@Override
	@PutMapping("/actualizar/{id}")
	public ResponseEntity update(@RequestBody DomicilioDTO t, @PathVariable int id) {
		
		return ResponseEntity.status(201).body(domicilioService.update(t, id));
	}

	@Override
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = domicilioService.delete(id);
		if (det) {
			return ResponseEntity.status(204).body("");
		}else {
			return ResponseEntity.status(400).body("");
		}
	}


}
