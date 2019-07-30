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

import ml.work.main.dtos.ArticuloDTO;
import ml.work.main.dtos.MensajeDTO;
import ml.work.main.dtos.NuevoUsuarioDTO;
import ml.work.main.service.ArticuloService;
import ml.work.main.entities.Articulo;


@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "/api/v1/articulos")
public class ArticuloController implements ObjectController<ArticuloDTO>{

	@Autowired
	private ArticuloService articuloService;

	/*public ArticuloController(ArticuloService articuloService) {
		this.articuloService = articuloService;
	}*/

	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/lista")
	/*public ArrayList<ArticuloDTO> getAll() {
		return ResponseEntity.status(200).body(articuloService.getAll()).getBody();
	}*/
	public ResponseEntity<List<ArticuloDTO>> getAll(){
        List<ArticuloDTO> lista = articuloService.getAll();
        return new ResponseEntity<List<ArticuloDTO>>(lista, HttpStatus.OK);
    }
	
	/*@Override
	@CrossOrigin("*")
	@GetMapping(path = "lista/{id}")
	public ArticuloDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(articuloService.getOne(id)).getBody();
	}*/
	
	@CrossOrigin("*")	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<ArticuloDTO> getOne(@PathVariable int id){
		if(!articuloService.existePorId(id))
			return new ResponseEntity(new MensajeDTO("no existe ese articulo"), HttpStatus.NOT_FOUND);
	    ArticuloDTO articulo = articuloService.getOne(id);
	    return new ResponseEntity<ArticuloDTO>(articulo, HttpStatus.OK);
	}
		
	@GetMapping(path = "lista/primas/{buscar}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ArrayList<ArticuloDTO> getInsumoEnLista(@PathVariable boolean buscar) {
		return ResponseEntity.status(200).body(articuloService.getInsumoEnLista(buscar)).getBody();
	}
	
	@GetMapping(path = "lista/vendibles/{buscar}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ArrayList<ArticuloDTO> getVendibleEnLista(@PathVariable boolean buscar) {
		return ResponseEntity.status(200).body(articuloService.getVendibleEnLista(buscar)).getBody();
	}

	
	
	@PostMapping("nuevo")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity save(@RequestBody ArticuloDTO art) {
		
		if(StringUtils.isBlank(art.getNombre_articulo()))
	        return new ResponseEntity(new MensajeDTO("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	    if((Float)art.getPrecioA() == null || art.getPrecioA()==0 && art.isEsPrima()==false)
	        return new ResponseEntity(new MensajeDTO("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
	    if(articuloService.existePorNombre(art.getNombre_articulo()))
	        return new ResponseEntity(new MensajeDTO("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
	    articuloService.save(art);
	    return new ResponseEntity(new MensajeDTO("producto guardado"), HttpStatus.CREATED);
	
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity update(@RequestBody ArticuloDTO t, @PathVariable int id) {
			
			return ResponseEntity.status(201).body(articuloService.update(t, id));
	}
	/*@PutMapping("/actualizar/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> update(@RequestBody ArticuloDTO art, @PathVariable("id") int id) {
		
		if(!articuloService.existePorId(id))
            return new ResponseEntity(new MensajeDTO("no existe ese producto"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(art.getNombre_articulo()))
            return new ResponseEntity(new MensajeDTO("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if((Float)art.getPrecioA() == null || art.getPrecioA()==0)
            return new ResponseEntity(new MensajeDTO("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
        if(articuloService.existePorNombre(art.getNombre_articulo()) &&
        		articuloService.getNombre(art.getNombre_articulo()).get().getId_articulo() != id)
            return new ResponseEntity(new MensajeDTO("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        ArticuloDTO artUpdate = articuloService.getOne(id);
        artUpdate.setNombre_articulo(art.getNombre_articulo());
        artUpdate.setPrecioA(art.getPrecioA());
        articuloService.save(artUpdate);
        return new ResponseEntity(new MensajeDTO("articulo actualizado"), HttpStatus.CREATED);
	}*/
	
	
	@DeleteMapping("/borrar/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable int id) {
		
		if(!articuloService.existePorId(id))
            return new ResponseEntity(new MensajeDTO("no existe ese articulo"), HttpStatus.NOT_FOUND);
        articuloService.delete(id);
        return new ResponseEntity(new MensajeDTO("articulo eliminado"), HttpStatus.OK);
        
	}
	

}
