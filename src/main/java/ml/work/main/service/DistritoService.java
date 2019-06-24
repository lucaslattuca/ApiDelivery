package ml.work.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ml.work.main.dtos.DistritoDTO;
import ml.work.main.entities.Distrito;
import ml.work.main.repositories.DistritoRepository;

@Service
public class DistritoService implements ObjectService<DistritoDTO> {

	private DistritoRepository distritoRepository;

	public DistritoService(DistritoRepository distritoRepository) {
		this.distritoRepository = distritoRepository;
	}

	@Override
	public List<DistritoDTO> getAll() {
		List<DistritoDTO> result = new ArrayList<>();
		for (Distrito distrito : distritoRepository.findAll()) {
			DistritoDTO temp = new DistritoDTO();
			temp.setId_Distrito(distrito.getId_Distrito());
			temp.setNombreDistrito(distrito.getNombreDistrito());
			temp.setLocalidad(distrito.getLocalidad());
//			temp.setDomicilios(distrito.getDomicilios());
			result.add(temp);
		}
		return result;
	}

	@Override
	public DistritoDTO getOne(int id) {
		Optional<Distrito> aOptional = distritoRepository.findById(id);
		DistritoDTO temp = new DistritoDTO();
		try {
			Distrito distrito = aOptional.get();
			temp.setId_Distrito(distrito.getId_Distrito());
			temp.setNombreDistrito(distrito.getNombreDistrito());
			temp.setLocalidad(distrito.getLocalidad());
//			temp.setDomicilios(distrito.getDomicilios());
		} catch (Exception e) {
			System.out.println("No existe el id");
		}
		return temp;
	}

	@Override
	public DistritoDTO save(DistritoDTO t) {
		Distrito distrito = new Distrito();
//		distrito.setDomicilios(t.getDomicilios());
		distrito.setLocalidad(t.getLocalidad());
		distrito.setNombreDistrito(t.getNombreDistrito());
		
		distritoRepository.save(distrito);
		t.setId_Distrito(distrito.getId_Distrito());
		return t;
	}

	@Override
	public DistritoDTO update(DistritoDTO t, int id) {
		Optional<Distrito> pOptional = distritoRepository.findById(id);
		Distrito temp = new Distrito();

		try {
			temp = pOptional.get();
//			temp.setDomicilios(t.getDomicilios());
			temp.setLocalidad(t.getLocalidad());
			temp.setNombreDistrito(t.getNombreDistrito());
			distritoRepository.save(temp);
			t.setId_Distrito(temp.getId_Distrito());

		} catch (Exception e) {
			System.out.println("No existe");
		}
		return t;
	}

	@Override
	public boolean delete(int id) {

		try {
			distritoRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
