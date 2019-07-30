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

import ml.work.main.dtos.MensajeDTO;
import ml.work.main.dtos.PedidoDTO;
import ml.work.main.service.PedidoService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "/api/v1/pedidos")
public class PedidoController implements ObjectController<PedidoDTO> {

	private PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/lista")
	public ResponseEntity<List<PedidoDTO>> getAll(){
        List<PedidoDTO> lista = pedidoService.getAll();
        return new ResponseEntity<List<PedidoDTO>>(lista, HttpStatus.OK);
    }

	@Override
	@GetMapping(path = "/detalle/{id}")
	public ResponseEntity<PedidoDTO> getOne(@PathVariable int id) {
		if(!pedidoService.existePorId(id))
			return new ResponseEntity(new MensajeDTO("no existe ese pedido"), HttpStatus.NOT_FOUND);
	    
		PedidoDTO pedido = pedidoService.getOne(id);
		
	    return new ResponseEntity<PedidoDTO>(pedido, HttpStatus.OK);
	}

	@Override
	@PostMapping("nuevo")
	public ResponseEntity save(@RequestBody PedidoDTO body) {
		PedidoDTO temp = pedidoService.save(body);

		if (temp.getNumPedido() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request fallo al generar pedido'}");
		}
	}
	
	
	@Override
	@PutMapping("/actualizar/{id}")
	public ResponseEntity update(@RequestBody PedidoDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(pedidoService.update(t, id));
	}

	@Override
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = pedidoService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Successful Delete'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Unsuccessful delete'");
		}
	}

}

