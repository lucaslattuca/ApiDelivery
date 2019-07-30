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

import ml.work.main.dtos.NuevoUsuarioDTO;
import ml.work.main.service.UsuarioService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "/api/v1/clientes")
public class ClienteController implements ObjectController<NuevoUsuarioDTO>{

private UsuarioService clienteService;
	
	public ClienteController(UsuarioService clienteService) {
		this.clienteService = clienteService;
	}

	@Override
	@CrossOrigin("*")
	@GetMapping(path ="/lista")
	public ResponseEntity<List<NuevoUsuarioDTO>> getAll(){
        List<NuevoUsuarioDTO> lista = clienteService.getAll();
        return new ResponseEntity<List<NuevoUsuarioDTO>>(lista, HttpStatus.OK);
    }
	
	@Override
	@CrossOrigin("*")	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<NuevoUsuarioDTO> getOne(@PathVariable int id){
	     NuevoUsuarioDTO uno = clienteService.getOne(id);
	    return new ResponseEntity<NuevoUsuarioDTO>(uno, HttpStatus.OK);
	}

	@Override
	@PostMapping("nuevo")
	public ResponseEntity save(@RequestBody NuevoUsuarioDTO t) {
		NuevoUsuarioDTO temp = clienteService.save(t);
		
		if (temp.getNombreUsuario() != null) {
			return ResponseEntity.status(201).body(temp);
		}else {
			return ResponseEntity.status(400).body("{error : 'bad request'}");
		}
		
	}

	@Override
	@PutMapping("/actualizar/{id}")
	public ResponseEntity update(@RequestBody NuevoUsuarioDTO t, @PathVariable int id) {
		
		return ResponseEntity.status(201).body(clienteService.update(t, id));
	}

	@Override
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = clienteService.delete(id);
		
		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Borrado con éxito!'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Ocurrió un problema al eliminar'");
		}
	}


}
