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

import ml.work.main.dtos.DetalleFacturaDTO;
import ml.work.main.service.DetalleFacturaService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path="api/v1/detalles_factura")
public class DetalleFacturaController implements ObjectController<DetalleFacturaDTO>{

	private DetalleFacturaService detalleFacturaService;

	public DetalleFacturaController(DetalleFacturaService detalleFacturaService) {
		this.detalleFacturaService = detalleFacturaService;
	}	
	
	@Override
	@CrossOrigin("*")
	@GetMapping(path="/")
	public ArrayList<DetalleFacturaDTO> getAll() {
		return ResponseEntity.status(200).body(detalleFacturaService.getAll()).getBody();
	}
	
	@GetMapping(path="/porPedido/{idPedido}")
	public ArrayList<DetalleFacturaDTO> getXPedido(@PathVariable int idPedido) {
		return ResponseEntity.status(200).body(detalleFacturaService.getXPedido(idPedido)).getBody();
	}


	@Override
	@GetMapping(path = "/{id}")
	public DetalleFacturaDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(detalleFacturaService.getOne(id)).getBody();
	}

	@Override
	@PostMapping("/")
	public ResponseEntity save(@RequestBody DetalleFacturaDTO body) {
		DetalleFacturaDTO temp = detalleFacturaService.save(body);

		if (temp.getIdDetalle() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity updateEntity(@RequestBody DetalleFacturaDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(detalleFacturaService.update(t, id));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEntity(@PathVariable int id) {
		boolean det = detalleFacturaService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Successful Delete'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Unsuccessful delete'");
		}
	}

}
