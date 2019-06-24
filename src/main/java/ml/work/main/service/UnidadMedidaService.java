package ml.work.main.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ml.work.main.dtos.UnidadMedidaDTO;
import ml.work.main.entities.UnidadMedida;
import ml.work.main.repositories.UnidadMedidaRepository;

@Service
public class UnidadMedidaService implements ObjectService<UnidadMedidaDTO>{

	private UnidadMedidaRepository unidadMedidaRepository;

	public UnidadMedidaService(UnidadMedidaRepository unidadMedidaRepository) {
		this.unidadMedidaRepository = unidadMedidaRepository;
	}
	
	@Override
	public ArrayList<UnidadMedidaDTO> getAll() {
		ArrayList<UnidadMedidaDTO> result = new ArrayList<>();

		for (UnidadMedida medida : unidadMedidaRepository.findAll()) {
			UnidadMedidaDTO temp = new UnidadMedidaDTO();

			temp.setId_medida(medida.getId_medida());
			temp.setTipo_medida(medida.getTipo_medida());

			result.add(temp);
		}
		return result;
	}

	@Override
	public UnidadMedidaDTO getOne(int id) {
		Optional<UnidadMedida> temp = unidadMedidaRepository.findById(id); 
		UnidadMedidaDTO result = new UnidadMedidaDTO();

		try {

			UnidadMedida resultBD = temp.get();

			result.setId_medida(resultBD.getId_medida());
			result.setTipo_medida(resultBD.getTipo_medida());

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return result;
	}

	@Override
	public UnidadMedidaDTO save(UnidadMedidaDTO body) {
		UnidadMedida guardado = new UnidadMedida();

		guardado.setTipo_medida(body.getTipo_medida());

		try {
			unidadMedidaRepository.save(guardado);
			body.setId_medida(guardado.getId_medida());
		} catch (Exception e) {
			System.out.println("Error al guardar");
		}
		return body;
	}

	@Override
	public UnidadMedidaDTO update(UnidadMedidaDTO t, int id) {
		Optional<UnidadMedida> pOptional = unidadMedidaRepository.findById(id);

		UnidadMedida temp = new UnidadMedida();

		try {
			temp = pOptional.get();

			temp.setTipo_medida(t.getTipo_medida());

			unidadMedidaRepository.save(temp);
			t.setId_medida(temp.getId_medida());

		} catch (Exception e) {
			System.out.println("No existe");
		}
		return t;
	}

	@Override
	public boolean delete(int id) {
		try {
			unidadMedidaRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
