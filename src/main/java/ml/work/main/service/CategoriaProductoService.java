package ml.work.main.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ml.work.main.dtos.CategoriaProductoDTO;
import ml.work.main.entities.CategoriaProducto;
import ml.work.main.repositories.CategoriaProductoRepository;

@Service
public class CategoriaProductoService implements ObjectService<CategoriaProductoDTO> {

	private CategoriaProductoRepository categoriaProductoRepository;

	public CategoriaProductoService(CategoriaProductoRepository categoriaProductoRepository) {
		this.categoriaProductoRepository = categoriaProductoRepository;
	}

	@Override
	public ArrayList<CategoriaProductoDTO> getAll() {
		ArrayList<CategoriaProductoDTO> result = new ArrayList<>();

		for (CategoriaProducto categoria : categoriaProductoRepository.findAll()) {
			CategoriaProductoDTO temp = new CategoriaProductoDTO();

			temp.setId_categoria(categoria.getId_categoria());
			temp.setNombre_categoria(categoria.getNombre_categoria());		
			temp.setEsPlato(categoria.isEsPlato());

			result.add(temp);
		}

		return result;
	}

	@Override
	public CategoriaProductoDTO getOne(int id) {
		Optional<CategoriaProducto> temp = categoriaProductoRepository.findById(id); 
		CategoriaProductoDTO result = new CategoriaProductoDTO();

		try {

			CategoriaProducto resultBD = temp.get();

			result.setId_categoria(resultBD.getId_categoria());
			result.setNombre_categoria(resultBD.getNombre_categoria());	
			result.setEsPlato(resultBD.isEsPlato());

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return result;
	}

	@Override
	public CategoriaProductoDTO save(CategoriaProductoDTO body) {
		CategoriaProducto guardado = new CategoriaProducto();

		guardado.setNombre_categoria(body.getNombre_categoria());
		guardado.setEsPlato(body.isEsPlato());

		try {
			categoriaProductoRepository.save(guardado);
			body.setId_categoria(guardado.getId_categoria());
		} catch (Exception e) {
			System.out.println("Error al guardar");
		}
		return body;
	}

	@Override
	public CategoriaProductoDTO update(CategoriaProductoDTO t, int id) {
		Optional<CategoriaProducto> pOptional = categoriaProductoRepository.findById(id);

		CategoriaProducto temp = new CategoriaProducto();

		try {
			temp = pOptional.get();

			temp.setNombre_categoria(t.getNombre_categoria());
			temp.setEsPlato(t.isEsPlato());

			categoriaProductoRepository.save(temp);
			t.setId_categoria(temp.getId_categoria());

		} catch (Exception e) {
			System.out.println("No existe");
		}
		return t;
	}

	@Override
	public boolean delete(int id) {
		try {
			categoriaProductoRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
