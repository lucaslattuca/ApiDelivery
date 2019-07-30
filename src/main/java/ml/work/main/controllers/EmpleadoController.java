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

import ml.work.main.dtos.EmpleadoDTO;
import ml.work.main.dtos.LocalidadDTO;
import ml.work.main.entities.Usuario;
import ml.work.main.service.EmpleadoService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "/api/v1/empleados")
public class EmpleadoController implements ObjectController<EmpleadoDTO>{

	private EmpleadoService empleadoService;

	public EmpleadoController(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}
	
	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/lista")
	public ResponseEntity<List<EmpleadoDTO>> getAll(){
        List<EmpleadoDTO> lista = empleadoService.getAll();
        return new ResponseEntity<List<EmpleadoDTO>>(lista, HttpStatus.OK);
    }

	@Override
	@GetMapping("/detalle/{id}")
	public ResponseEntity<EmpleadoDTO> getOne(@PathVariable int id){
		EmpleadoDTO uno = empleadoService.getOne(id);
	    return new ResponseEntity<EmpleadoDTO>(uno, HttpStatus.OK);
	}
	
	
	@Override
	@PostMapping("nuevo")
	public ResponseEntity save(@RequestBody EmpleadoDTO body) {
		EmpleadoDTO temp = empleadoService.save(body);

		if (temp.getIdEmpleado() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
	}
	
	@Override
	@PutMapping("/actualizar/{id}")
	public ResponseEntity update(@RequestBody EmpleadoDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(empleadoService.update(t, id));
	}

	@Override
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = empleadoService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Borrado con éxito!'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Ocurrió un problema al eliminar'");
		}
	}

	
}
