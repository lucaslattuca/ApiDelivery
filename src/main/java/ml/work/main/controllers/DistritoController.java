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
import ml.work.main.dtos.ClienteDTO;
import ml.work.main.dtos.DistritoDTO;
import ml.work.main.dtos.MensajeDTO;
import ml.work.main.service.DistritoService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "/api/v1/Distritos")
public class DistritoController implements ObjectController<DistritoDTO>{

	private DistritoService distritoService;
	
	public DistritoController(DistritoService distritoService) {
		this.distritoService = distritoService;
	}

	@Override
	@CrossOrigin("*")
	@GetMapping(path ="/lista")
	public ResponseEntity<List<DistritoDTO>> getAll(){
        List<DistritoDTO> lista = distritoService.getAll();
        return new ResponseEntity<List<DistritoDTO>>(lista, HttpStatus.OK);
    }
	
	@Override
	@CrossOrigin("*")	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<DistritoDTO> getOne(@PathVariable int id){
	     DistritoDTO uno = distritoService.getOne(id);
	    return new ResponseEntity<>(uno, HttpStatus.OK);
	}
	
	

	@Override
	@PostMapping("nuevo")
	public ResponseEntity save(@RequestBody DistritoDTO t) {
		DistritoDTO temp = distritoService.save(t);
		
		if (temp.getId_Distrito() != 0) {
			return ResponseEntity.status(201).body(temp);
		}else {
			return ResponseEntity.status(400).body("{error : 'bad request'}");
		}
		
	}

	@Override
	@PutMapping("/actualizar/{id}")
	public ResponseEntity update(@RequestBody DistritoDTO t, @PathVariable int id) {
		
		return ResponseEntity.status(201).body(distritoService.update(t, id));
	}

	@Override
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = distritoService.delete(id);
		if (det) {
			return ResponseEntity.status(204).body("");
		}else {
			return ResponseEntity.status(400).body("");
		}
	}

}
