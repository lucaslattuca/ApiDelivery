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

import ml.work.main.dtos.PedidoDTO;
import ml.work.main.service.PedidoService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "api/v1/pedidos")
public class PedidoController implements ObjectController<PedidoDTO> {

	private PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/")
	public ArrayList<PedidoDTO> getAll() {

		return ResponseEntity.status(200).body(pedidoService.getAll()).getBody();
	}

	@Override
	@GetMapping(path = "/{id}")
	public PedidoDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(pedidoService.getOne(id)).getBody();
	}

	@Override
	@PostMapping("/")
	public ResponseEntity save(@RequestBody PedidoDTO body) {
		PedidoDTO temp = pedidoService.save(body);

		if (temp.getNumPedido() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'wrong request'}");
		}
	}
	
	
	@Override
	@PutMapping("/{id}")
	public ResponseEntity updateEntity(@RequestBody PedidoDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(pedidoService.update(t, id));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEntity(@PathVariable int id) {
		boolean det = pedidoService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Successful Delete'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Unsuccessful delete'");
		}
	}

}

