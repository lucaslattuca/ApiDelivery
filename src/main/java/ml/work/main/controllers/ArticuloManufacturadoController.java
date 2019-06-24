package ml.work.main.controllers;

import java.util.ArrayList;

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
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import ml.work.main.entities.ArticuloManufacturado;
import ml.work.main.dtos.ArticuloManufacturadoDTO;
import ml.work.main.dtos.MensajeDTO;
import ml.work.main.service.ArticuloManufacturadoService;

@Controller
@RestController
//@CrossOrigin(origins = "*") 
@RequestMapping(path = "api/v1/manufacturados")
public class ArticuloManufacturadoController implements ObjectController<ArticuloManufacturadoDTO>{

	private ArticuloManufacturadoService articuloManufacturadoService;

	public ArticuloManufacturadoController(ArticuloManufacturadoService articuloManufacturadoService) {
		this.articuloManufacturadoService = articuloManufacturadoService;
	}
	
	@Override
	//@CrossOrigin("*")
	@GetMapping(path = "/")
	public ArrayList<ArticuloManufacturadoDTO> getAll() {
		return ResponseEntity.status(200).body(articuloManufacturadoService.getAll()).getBody();
	}
	
	@GetMapping(path = "/disponibles/{buscar}")
	public ArrayList<ArticuloManufacturadoDTO> getEnMenu(@PathVariable boolean buscar) {
		return ResponseEntity.status(200).body(articuloManufacturadoService.getEnMenu(buscar)).getBody();
	}	
	
	@Override
	@GetMapping(path = "/{id}")
	public ArticuloManufacturadoDTO getOne(@PathVariable int id) {
		
		return ResponseEntity.status(200).body(articuloManufacturadoService.getOne(id)).getBody();
	}
	
	
	@Override
	@PostMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity save(@RequestBody ArticuloManufacturadoDTO body) {
		ArticuloManufacturadoDTO temp = articuloManufacturadoService.save(body);

		if (temp.getId_artManuf() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
	}
	
	
	/*@Override
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity updateEntity(@RequestBody ArticuloManufacturadoDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(articuloManufacturadoService.update(t, id));
	}*/
	
	
	@PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateEntity(@RequestBody ArticuloManufacturadoDTO manuf, @PathVariable("id") int id){
        if(!articuloManufacturadoService.existePorId(id))
            return new ResponseEntity(new MensajeDTO("no existe ese producto"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(manuf.getNombre_articuloM()))
            return new ResponseEntity(new MensajeDTO("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if((Float)manuf.getPrecioM() == null || manuf.getPrecioM()==0)
            return new ResponseEntity(new MensajeDTO("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
        if(articuloManufacturadoService.existePorNombre(manuf.getNombre_articuloM()) &&
        		articuloManufacturadoService.getNombre(manuf.getNombre_articuloM()).get().getId_artManuf() != id)
            return new ResponseEntity(new MensajeDTO("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        ArticuloManufacturadoDTO prodUpdate = articuloManufacturadoService.getOne(id);
        prodUpdate.setNombre_articuloM(manuf.getNombre_articuloM());
        prodUpdate.setPrecioM(manuf.getPrecioM());
        articuloManufacturadoService.save(prodUpdate);
        return new ResponseEntity(new MensajeDTO("producto actualizado"), HttpStatus.CREATED);
    }
	
	
	

	@Override
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity deleteEntity(@PathVariable int id) {
		boolean det = articuloManufacturadoService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Successful Delete'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Unsuccessful delete'");
		}
	}

}
