package ml.work.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ml.work.main.dtos.LocalidadDTO;
import ml.work.main.entities.Localidad;
import ml.work.main.repositories.LocalidadRepository;

@Service
public class LocalidadService implements ObjectService<LocalidadDTO> {

	private LocalidadRepository localidadRepository;

	public LocalidadService(LocalidadRepository localidadRepository) {
		this.localidadRepository = localidadRepository;
	}

	@Override
	public List<LocalidadDTO> getAll() {
		List<LocalidadDTO> result = new ArrayList<>();
		for (Localidad localidad : localidadRepository.findAll()) {
			LocalidadDTO temp = new LocalidadDTO();
			temp.setId_Localidad(localidad.getId_Localidad());
			temp.setNombre_localidad(localidad.getNombre_localidad());
//			temp.setDistritos(localidad.getDistritos());
			result.add(temp);
		}
		return result;
	}

	@Override
	public LocalidadDTO getOne(int id) {
		Optional<Localidad> aOptional = localidadRepository.findById(id);
		LocalidadDTO temp = new LocalidadDTO();
		try {
			Localidad localidad = aOptional.get();
			temp.setId_Localidad(localidad.getId_Localidad());
			temp.setNombre_localidad(localidad.getNombre_localidad());
//			temp.setDistritos(localidad.getDistritos());
		} catch (Exception e) {
			System.out.println("No existe el id");
		}
		return temp;
	}

	@Override
	public LocalidadDTO save(LocalidadDTO t) {
		Localidad localidad = new Localidad();
//		localidad.setDistritos(t.getDistritos());
		localidad.setNombre_localidad(t.getNombre_localidad());
		
		localidadRepository.save(localidad);
		t.setId_Localidad(localidad.getId_Localidad());
		return t;
	}

	@Override
	public LocalidadDTO update(LocalidadDTO t, int id) {
		Optional<Localidad> pOptional = localidadRepository.findById(id);
		Localidad temp = new Localidad();

		try {
			temp = pOptional.get();
//			temp.setDistritos(t.getDistritos());
			temp.setNombre_localidad(t.getNombre_localidad());
			
			localidadRepository.save(temp);
			t.setId_Localidad(temp.getId_Localidad());

		} catch (Exception e) {
			System.out.println("No existe");
		}
		return t;
	}

	@Override
	public boolean delete(int id) {

		try {
			localidadRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
