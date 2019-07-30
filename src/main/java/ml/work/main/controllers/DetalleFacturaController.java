package ml.work.main.controllers;

import java.util.ArrayList;
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

import ml.work.main.dtos.DetalleFacturaDTO;
import ml.work.main.service.DetalleFacturaService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path="/api/v1/detalles_factura")
public class DetalleFacturaController implements ObjectController<DetalleFacturaDTO>{

	private DetalleFacturaService detalleFacturaService;

	public DetalleFacturaController(DetalleFacturaService detalleFacturaService) {
		this.detalleFacturaService = detalleFacturaService;
	}	
	
	@Override
	@CrossOrigin("*")
	@GetMapping(path="/lista")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<DetalleFacturaDTO>> getAll(){
        List<DetalleFacturaDTO> lista = detalleFacturaService.getAll();
        return new ResponseEntity<List<DetalleFacturaDTO>>(lista, HttpStatus.OK);
    }
	
	@Override
	@CrossOrigin("*")
	@GetMapping("/detalle/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<DetalleFacturaDTO> getOne(@PathVariable int id){
	     DetalleFacturaDTO uno = detalleFacturaService.getOne(id);
	    return new ResponseEntity<DetalleFacturaDTO>(uno, HttpStatus.OK);
	}
	
	
	@GetMapping(path="/porPedido/{idPedido}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ArrayList<DetalleFacturaDTO> getXPedido(@PathVariable int idPedido) {
		return ResponseEntity.status(200).body(detalleFacturaService.getXPedido(idPedido)).getBody();
	}


	@Override
	@PostMapping("nuevo")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity save(@RequestBody DetalleFacturaDTO body) {
		DetalleFacturaDTO temp = detalleFacturaService.save(body);

		if (temp.getIdDetalle() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request fallo al generar detalle'}");
		}
	}

	@Override
	@PutMapping("/actualizar/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity update(@RequestBody DetalleFacturaDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(detalleFacturaService.update(t, id));
	}

	@Override
	@DeleteMapping("/borrar/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = detalleFacturaService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Successful Delete'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Unsuccessful delete'");
		}
	}

}
