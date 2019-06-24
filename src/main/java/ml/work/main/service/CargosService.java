package ml.work.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ml.work.main.dtos.CargosDTO;
import ml.work.main.entities.Cargos;
import ml.work.main.repositories.CargosRepository;

@Service
public class CargosService implements ObjectService<CargosDTO>{

	private CargosRepository cargosRepository;
	
	public CargosService(CargosRepository cargosRepository) {
		this.cargosRepository = cargosRepository;
	}
	
	@Override
	public List<CargosDTO> getAll() {
		List<CargosDTO> result = new ArrayList<>();
		
		for(Cargos cargo : cargosRepository.findAll()) {
			
			CargosDTO temp = new CargosDTO();
			
			temp.setId_cargo(cargo.getId_cargo());
			temp.setPuesto(cargo.getPuesto());
			temp.setEmpleados(cargo.getEmpleados());
			
			result.add(temp);
		}
		
		return result;
	}

	@Override
	public CargosDTO getOne(int id) {
		Optional<Cargos> temp = cargosRepository.findById(id);
		
		CargosDTO result = new CargosDTO();
		
		try {
			Cargos resultBD = temp.get();
			
			result.setEmpleados(resultBD.getEmpleados());
			result.setId_cargo(resultBD.getId_cargo());
			result.setPuesto(resultBD.getPuesto());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	@Override
	public CargosDTO save(CargosDTO t) {
		Cargos guardado = new Cargos();
		
		guardado.setEmpleados(t.getEmpleados());
		guardado.setId_cargo(t.getId_cargo());
		guardado.setPuesto(t.getPuesto());
		
		try {
			cargosRepository.save(guardado);
			t.setId_cargo(guardado.getId_cargo());
		} catch (Exception e) {
			System.out.println("Error al guardar");
		}
		
		return t;
	}

	@Override
	public CargosDTO update(CargosDTO t, int id) {
		Optional<Cargos> pOptional = cargosRepository.findById(id);
		
		Cargos temp = new Cargos();
		
		try {
			temp = pOptional.get();
			
			temp.setEmpleados(t.getEmpleados());
			temp.setId_cargo(t.getId_cargo());
			temp.setPuesto(t.getPuesto());
			
			cargosRepository.save(temp);
			t.setId_cargo(temp.getId_cargo());
		} catch (Exception e) {
			System.out.println("No existe");
		}
		
		return t;
	}

	@Override
	public boolean delete(int id) {
		try {
			cargosRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
