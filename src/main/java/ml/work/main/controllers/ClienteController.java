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
import ml.work.main.entities.Persona;
import ml.work.main.service.ClienteService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "api/v1/clientes")
public class ClienteController extends Persona implements ObjectController<ClienteDTO>{

	private ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@Override
	@CrossOrigin("*")
	@GetMapping(path ="/")
	public List<ClienteDTO> getAll() {
		
		return ResponseEntity.status(200).body(clienteService.getAll()).getBody();
	}

	@Override
	@GetMapping("/{id}")
	public ClienteDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(clienteService.getOne(id)).getBody();
	}

	@Override
	@PostMapping("/")
	public ResponseEntity save(@RequestBody ClienteDTO t) {
		ClienteDTO temp = clienteService.save(t);
		
		if (temp.getId_usuario() != 0) {
			return ResponseEntity.status(201).body(temp);
		}else {
			return ResponseEntity.status(400).body("{error : 'bad request'}");
		}
		
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity updateEntity(@RequestBody ClienteDTO t, @PathVariable int id) {
		
		return ResponseEntity.status(201).body(clienteService.update(t, id));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEntity(@PathVariable int id) {
		boolean det = clienteService.delete(id);
		if (det) {
			return ResponseEntity.status(204).body("");
		}else {
			return ResponseEntity.status(400).body("");
		}
	}


}
