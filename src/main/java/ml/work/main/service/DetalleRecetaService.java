package ml.work.main.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ml.work.main.dtos.DetalleRecetaDTO;
import ml.work.main.entities.DetalleReceta;
import ml.work.main.repositories.DetalleRecetaRepository;

@Service
public class DetalleRecetaService implements ObjectService<DetalleRecetaDTO>{

	private DetalleRecetaRepository detalleRecetaRepository;

	public DetalleRecetaService(DetalleRecetaRepository detalleRecetaRepository) {
		this.detalleRecetaRepository = detalleRecetaRepository;
	}
	
	@Override
	public ArrayList<DetalleRecetaDTO> getAll() {
		ArrayList<DetalleRecetaDTO> result = new ArrayList<>();

		for (DetalleReceta detalle : detalleRecetaRepository.findAll()) {
			DetalleRecetaDTO temp = new DetalleRecetaDTO();

			temp.setId_receta(detalle.getId_receta());
			temp.setArticulo(detalle.getArticulo());
			temp.setArticuloManuf(detalle.getArticuloManuf());
			temp.setCantidad(detalle.getCantidad());
			temp.setFechaAnulado(detalle.getFechaAnulado());

			result.add(temp);
		}

		return result;
	}

	@Override
	public DetalleRecetaDTO getOne(int id) {
		Optional<DetalleReceta> temp = detalleRecetaRepository.findById(id);
		DetalleRecetaDTO result = new DetalleRecetaDTO();

		try {

			DetalleReceta resultBD = temp.get();

			result.setId_receta(resultBD.getId_receta());
			result.setCantidad(resultBD.getCantidad());
			result.setArticuloManuf(resultBD.getArticuloManuf());
			result.setArticulo(resultBD.getArticulo());
			result.setFechaAnulado(resultBD.getFechaAnulado());

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return result;
	}

	@Override
	public DetalleRecetaDTO save(DetalleRecetaDTO t) {
		DetalleReceta guardado = new DetalleReceta();

		guardado.setArticulo(t.getArticulo());
		guardado.setArticuloManuf(t.getArticuloManuf());
		guardado.setCantidad(t.getCantidad());
		guardado.setFechaAnulado(t.getFechaAnulado());

		try {
			detalleRecetaRepository.save(guardado);
			t.setId_receta(guardado.getId_receta());
		} catch (Exception e) {
			System.out.println("Error al guardar");
		}
		return t;
	}

	@Override
	public DetalleRecetaDTO update(DetalleRecetaDTO t, int id) {
		Optional<DetalleReceta> pOptional = detalleRecetaRepository.findById(id);

		DetalleReceta temp = new DetalleReceta();

		try {
			temp = pOptional.get();

			temp.setArticulo(t.getArticulo());
			temp.setArticuloManuf(t.getArticuloManuf());
			temp.setCantidad(t.getCantidad());
			temp.setFechaAnulado(t.getFechaAnulado());

			detalleRecetaRepository.save(temp);
			t.setId_receta(temp.getId_receta());

		} catch (Exception e) {
			System.out.println("No existe");
		}
		return t;
	}

	@Override
	public boolean delete(int id) {
		try {
			detalleRecetaRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
