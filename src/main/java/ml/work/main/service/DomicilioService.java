package ml.work.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ml.work.main.dtos.DomicilioDTO;
import ml.work.main.entities.Domicilio;
import ml.work.main.repositories.DomicilioRepository;

@Service
public class DomicilioService implements ObjectService<DomicilioDTO> {

	private DomicilioRepository domicilioRepository;

	public DomicilioService(DomicilioRepository domicilioRepository) {
		this.domicilioRepository = domicilioRepository;
	}

	@Override
	public List<DomicilioDTO> getAll() {
		List<DomicilioDTO> result = new ArrayList<>();
		for (Domicilio domicilio : domicilioRepository.findAll()) {
			DomicilioDTO temp = new DomicilioDTO();
			temp.setCalle(domicilio.getCalle());
			temp.setDistrito(domicilio.getDistrito());
			temp.setId_domicilio(domicilio.getId_domicilio());
			temp.setNumCasa(domicilio.getNumCasa());
			temp.setNumDepartamento(domicilio.getNumDepartamento());
			temp.setNumPiso(domicilio.getNumPiso());
//			temp.setPersonas(domicilio.getPersonas());
			result.add(temp);
		}
		return result;
	}

	@Override
	public DomicilioDTO getOne(int id) {
		Optional<Domicilio> aOptional = domicilioRepository.findById(id);
		DomicilioDTO temp = new DomicilioDTO();
		try {
			Domicilio domicilio = aOptional.get();
			temp.setCalle(domicilio.getCalle());
			temp.setDistrito(domicilio.getDistrito());
			temp.setId_domicilio(domicilio.getId_domicilio());
			temp.setNumCasa(domicilio.getNumCasa());
			temp.setNumDepartamento(domicilio.getNumDepartamento());
			temp.setNumPiso(domicilio.getNumPiso());
//			temp.setPersonas(domicilio.getPersonas());
		} catch (Exception e) {
			System.out.println("No existe el id");
		}
		return temp;
	}

	@Override
	public DomicilioDTO save(DomicilioDTO t) {
		
		Domicilio domicilio = new Domicilio();
		
		domicilio.setCalle(t.getCalle());
		domicilio.setNumCasa(t.getNumCasa());
		domicilio.setNumDepartamento(t.getNumDepartamento());
		domicilio.setNumPiso(t.getNumPiso());
		domicilio.setDistrito(t.getDistrito());
//		domicilio.setPersonas(t.getPersonas());
		
		domicilioRepository.save(domicilio);
		t.setId_domicilio(domicilio.getId_domicilio());

		return t;
	}

	@Override
	public DomicilioDTO update(DomicilioDTO t, int id) {
		Optional<Domicilio> pOptional = domicilioRepository.findById(id);
		Domicilio temp = new Domicilio();

		try {
			temp = pOptional.get();
			temp.setCalle(t.getCalle());
			temp.setNumCasa(t.getNumCasa());
			temp.setNumDepartamento(t.getNumDepartamento());
			temp.setNumPiso(t.getNumPiso());
			temp.setDistrito(t.getDistrito());
//			temp.setPersonas(t.getPersonas());

			domicilioRepository.save(temp);
			t.setId_domicilio(temp.getId_domicilio());

		} catch (Exception e) {
			System.out.println("No existe");
		}
		return t;
	}

	@Override
	public boolean delete(int id) {

		try {
			domicilioRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
