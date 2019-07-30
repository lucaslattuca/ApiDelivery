package ml.work.main.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ml.work.main.dtos.ArticuloDTO;
import ml.work.main.dtos.NuevoUsuarioDTO;
import ml.work.main.entities.Articulo;

public interface ObjectController<T> {
	
	public ResponseEntity<List<T>> getAll();
	public ResponseEntity<T> getOne(int id);
	public ResponseEntity save(T t);
	public ResponseEntity update (T t, int id);
	public ResponseEntity delete (int id);

}
