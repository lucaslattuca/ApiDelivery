package ml.work.main.controllers;

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

import ml.work.main.dtos.FacturaDTO;
import ml.work.main.service.FacturaService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "/api/v1/facturas")
public class FacturaController implements ObjectController<FacturaDTO> {

	private FacturaService facturaService;

	public FacturaController(FacturaService facturaService) {
		this.facturaService = facturaService;
	}

	@Override
	@CrossOrigin("*")
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(path = "/lista")
	public ResponseEntity<List<FacturaDTO>> getAll(){
        List<FacturaDTO> factura = facturaService.getAll();
        return new ResponseEntity<List<FacturaDTO>>(factura, HttpStatus.OK);
    }

	@Override
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/detalle/{id}")
	public ResponseEntity<FacturaDTO> getOne(@PathVariable int id){
		FacturaDTO factura = facturaService.getOne(id);
	    return new ResponseEntity<FacturaDTO>(factura, HttpStatus.OK);
	}

	@Override
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("nuevo")
	public ResponseEntity save(@RequestBody FacturaDTO body) {
		FacturaDTO temp = facturaService.save(body);

		if (temp.getNumFactura() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
	}
	
	@Override
	//@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/actualizar/{id}")
	public ResponseEntity update(@RequestBody FacturaDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(facturaService.update(t, id));
	}
	
	
	@Override
	//@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = facturaService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Successful Delete'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Unsuccessful delete'");
		}
	}

}
