package ml.work.main.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import ml.work.main.dtos.ArticuloManufacturadoDTO;
import ml.work.main.dtos.MensajeDTO;
import ml.work.main.entities.ArticuloManufacturado;
import ml.work.main.service.ArticuloManufacturadoService;


@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "/api/v1/manufacturados")
public class ArticuloManufacturadoController implements ObjectController<ArticuloManufacturadoDTO>{

	@Autowired
	private ArticuloManufacturadoService articuloManufacturadoService;

	/*public ArticuloManufacturadoController(ArticuloManufacturadoService articuloManufacturadoService) {
		this.articuloManufacturadoService = articuloManufacturadoService;
	}*/
	
	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/lista")
	public ResponseEntity<List<ArticuloManufacturadoDTO>> getAll(){
        List<ArticuloManufacturadoDTO> lista = articuloManufacturadoService.getAll();
        return new ResponseEntity<List<ArticuloManufacturadoDTO>>(lista, HttpStatus.OK);
    }
	@CrossOrigin("*")
	@GetMapping(path = "/listado")
	public ResponseEntity<List<ArticuloManufacturado>> getLista(){
        List<ArticuloManufacturado> lista = articuloManufacturadoService.obtenerTodos();
        return new ResponseEntity<List<ArticuloManufacturado>>(lista, HttpStatus.OK);
    }
	
	
	@GetMapping(path = "/disponibles/{buscar}")
	public ArrayList<ArticuloManufacturadoDTO> getEnMenu(@PathVariable boolean buscar) {
		return ResponseEntity.status(200).body(articuloManufacturadoService.getEnMenu(buscar)).getBody();
	}	
	
	
	/*public ArticuloManufacturadoDTO getOne(@PathVariable int id) {
		
		return ResponseEntity.status(200).body(articuloManufacturadoService.getOne(id)).getBody();
	}*/
	@CrossOrigin("*")	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<ArticuloManufacturadoDTO> getOne(@PathVariable int id){
		if(!articuloManufacturadoService.existePorId(id))
			return new ResponseEntity(new MensajeDTO("no existe ese articulo manufacturado"), HttpStatus.NOT_FOUND);
	    ArticuloManufacturadoDTO manufacturado = articuloManufacturadoService.getOne(id);
	    return new ResponseEntity<ArticuloManufacturadoDTO>(manufacturado, HttpStatus.OK);
	}
	
	/*@Override
	@PostMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity save(@RequestBody ArticuloManufacturadoDTO body) {
		ArticuloManufacturadoDTO temp = articuloManufacturadoService.save(body);

		if (temp.getId_artManuf() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
	}*/
	@Override
	@PostMapping("nuevo")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity save(@RequestBody ArticuloManufacturadoDTO manuf){
		 
       if(StringUtils.isBlank(manuf.getNombre_articuloM()))
            return new ResponseEntity(new MensajeDTO("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       if((Float)manuf.getPrecioM() == null || manuf.getPrecioM()==0)
            return new ResponseEntity(new MensajeDTO("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
       if(articuloManufacturadoService.existePorNombre(manuf.getNombre_articuloM()))
            return new ResponseEntity(new MensajeDTO("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
       articuloManufacturadoService.save(manuf);
       return new ResponseEntity(new MensajeDTO("producto guardado"), HttpStatus.CREATED);
    }
	
	
	@Override
	@PutMapping("/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity update(@RequestBody ArticuloManufacturadoDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(articuloManufacturadoService.update(t, id));
	}
	
	/*@Override
	@PutMapping("/actualizar/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> update(@RequestBody ArticuloManufacturadoDTO manuf, @PathVariable("id") int id){
        if(!articuloManufacturadoService.existePorId(id))
            return new ResponseEntity(new MensajeDTO("no existe ese articulo manufacturado"), HttpStatus.NOT_FOUND);
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
        return new ResponseEntity(new MensajeDTO("articulo manufacturado actualizado"), HttpStatus.CREATED);
    }*/
	
	
	@Override
	@DeleteMapping("/borrar/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable int id) {
		
		if(!articuloManufacturadoService.existePorId(id))
            return new ResponseEntity(new MensajeDTO("no existe ese articulo"), HttpStatus.NOT_FOUND);
        articuloManufacturadoService.delete(id);
        return new ResponseEntity(new MensajeDTO("articulo eliminado"), HttpStatus.OK);
        
	}

}
