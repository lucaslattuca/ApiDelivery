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

import ml.work.main.dtos.LocalidadDTO;
import ml.work.main.service.LocalidadService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "/api/v1/localidades")
public class LocalidadController implements ObjectController<LocalidadDTO>{

	private LocalidadService localidadService;
	
	public LocalidadController(LocalidadService localidadService) {
		this.localidadService = localidadService;
	}

	@Override
	@CrossOrigin("*")
	@GetMapping(path ="/lista")
	public ResponseEntity<List<LocalidadDTO>> getAll(){
        List<LocalidadDTO> lista = localidadService.getAll();
        return new ResponseEntity<List<LocalidadDTO>>(lista, HttpStatus.OK);
    }

	@Override
	@GetMapping("/detalle/{id}")
	public ResponseEntity<LocalidadDTO> getOne(@PathVariable int id){
		LocalidadDTO localidad = localidadService.getOne(id);
	    return new ResponseEntity<LocalidadDTO>(localidad, HttpStatus.OK);
	}

	@Override
	@PostMapping("nuevo")
	public ResponseEntity save(@RequestBody LocalidadDTO t) {
		LocalidadDTO temp = localidadService.save(t);
		
		if (temp.getId_Localidad() != 0) {
			return ResponseEntity.status(201).body(temp);
		}else {
			return ResponseEntity.status(400).body("{error : 'bad request'}");
		}
		
	}

	@Override
	@PutMapping("/actualizar/{id}")
	public ResponseEntity update(@RequestBody LocalidadDTO t, @PathVariable int id) {
		
		return ResponseEntity.status(201).body(localidadService.update(t, id));
	}

	@Override
	@DeleteMapping("/borrar/id}")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = localidadService.delete(id);
		if (det) {
			return ResponseEntity.status(204).body("");
		}else {
			return ResponseEntity.status(400).body("");
		}
	}


}
