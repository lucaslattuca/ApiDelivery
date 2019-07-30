package ml.work.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import ml.work.main.dtos.ArticuloManufacturadoDTO;
import ml.work.main.entities.ArticuloManufacturado;
import ml.work.main.repositories.ArticuloManufacturadoRepository;

@Service
@Transactional
public class ArticuloManufacturadoService implements ObjectService<ArticuloManufacturadoDTO>{

	@Autowired
	private ArticuloManufacturadoRepository articuloManufacturadoRepository;

	public ArticuloManufacturadoService(ArticuloManufacturadoRepository articuloManufacturadoRepository) {
		this.articuloManufacturadoRepository = articuloManufacturadoRepository;
	}
	
	@Override
	public ArrayList<ArticuloManufacturadoDTO> getAll() {
		ArrayList<ArticuloManufacturadoDTO> result = new ArrayList<>();

		for (ArticuloManufacturado manuf : articuloManufacturadoRepository.findAll()) {
			ArticuloManufacturadoDTO temp = new ArticuloManufacturadoDTO();

			temp.setId_artManuf(manuf.getId_artManuf());
			temp.setMinutosPrep(manuf.getMinutosPrep());
			temp.setNombre_articuloM(manuf.getNombre_articuloM());
			temp.setEnMenu(manuf.isEnMenu());
			temp.setCategoriaManuf(manuf.getCategoriaManuf());
			temp.setDetalle(manuf.getDetalle());
			temp.setFoto(manuf.getFoto());
			temp.setPrecioM(manuf.getPrecioM());
			
			result.add(temp);
		}

		return result;
	}
	
	public List<ArticuloManufacturado> obtenerTodos(){
        List<ArticuloManufacturado> lista = articuloManufacturadoRepository.findAll();
        return lista;
    }
	
	
//	Método para encontrar platos que están activos en el menú o no.
//	Con el booleano aviso si quiero los platos del menú o los que están dados de baja
	
	public ArrayList<ArticuloManufacturadoDTO> getEnMenu(boolean buscar) { 
		ArrayList<ArticuloManufacturadoDTO> result = new ArrayList<>();

		for (ArticuloManufacturado manuf : articuloManufacturadoRepository.findAll()) {
			ArticuloManufacturadoDTO temp = new ArticuloManufacturadoDTO();
			
			//si quiero platos del menú, y el artículo iterado cumple con esa condición
			if(buscar==true && manuf.isEnMenu()==true) {
				temp.setId_artManuf(manuf.getId_artManuf());
				temp.setMinutosPrep(manuf.getMinutosPrep());
				temp.setNombre_articuloM(manuf.getNombre_articuloM());
				temp.setEnMenu(manuf.isEnMenu());
				temp.setCategoriaManuf(manuf.getCategoriaManuf());
				temp.setDetalle(manuf.getDetalle());
				temp.setFoto(manuf.getFoto());
				temp.setPrecioM(manuf.getPrecioM());
				
				result.add(temp);
			}
			
			//si NO quiero platos del menú, y el artículo iterado cumple con esa condición
			if (buscar==false && manuf.isEnMenu()==false) {
				temp.setId_artManuf(manuf.getId_artManuf());
				temp.setMinutosPrep(manuf.getMinutosPrep());
				temp.setNombre_articuloM(manuf.getNombre_articuloM());
				temp.setEnMenu(manuf.isEnMenu());
				temp.setCategoriaManuf(manuf.getCategoriaManuf());
				temp.setDetalle(manuf.getDetalle());
				temp.setFoto(manuf.getFoto());
				temp.setPrecioM(manuf.getPrecioM());
				
				result.add(temp);
			}				
		}
		return result;
	}

	public Optional<ArticuloManufacturado>getNombre(String nM){
		return articuloManufacturadoRepository.findByNombreManufacturado(nM);
	}
	public boolean existePorNombre(String nM){
        return articuloManufacturadoRepository.existsByNombreManufacturado(nM);
    }
	public boolean existePorId(int id){
        return articuloManufacturadoRepository.existsById(id);
    }
	
	@Override
	public ArticuloManufacturadoDTO getOne(int id) {
		Optional<ArticuloManufacturado> temp = articuloManufacturadoRepository.findById(id); 
		ArticuloManufacturadoDTO result = new ArticuloManufacturadoDTO();

		try {

			ArticuloManufacturado resultBD = temp.get();

			result.setId_artManuf(resultBD.getId_artManuf());
			result.setMinutosPrep(resultBD.getMinutosPrep());
			result.setNombre_articuloM(resultBD.getNombre_articuloM());			
			result.setEnMenu(resultBD.isEnMenu());
			result.setCategoriaManuf(resultBD.getCategoriaManuf());
			result.setDetalle(resultBD.getDetalle());
			result.setFoto(resultBD.getFoto());
			result.setPrecioM(resultBD.getPrecioM());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return result;
	}

	@Override
	public ArticuloManufacturadoDTO save(ArticuloManufacturadoDTO body) {
		ArticuloManufacturado guardado = new ArticuloManufacturado();

		guardado.setNombre_articuloM(body.getNombre_articuloM());
		guardado.setMinutosPrep(body.getMinutosPrep());		
		guardado.setEnMenu(true);
		guardado.setCategoriaManuf(body.getCategoriaManuf());
		guardado.setDetalle(body.getDetalle());
		guardado.setFoto(body.getFoto());
		guardado.setPrecioM(body.getPrecioM());
		
		try {
			articuloManufacturadoRepository.save(guardado);
			body.setId_artManuf(guardado.getId_artManuf());
		} catch (Exception e) {
			System.out.println("Error al guardar");
		}
		return body;
	}

	@Override
	public ArticuloManufacturadoDTO update(ArticuloManufacturadoDTO t, int id) {
		Optional<ArticuloManufacturado> pOptional = articuloManufacturadoRepository.findById(id);

		ArticuloManufacturado temp = new ArticuloManufacturado();

		try {
			temp = pOptional.get();

			temp.setNombre_articuloM(t.getNombre_articuloM());
			temp.setMinutosPrep(t.getMinutosPrep());			
			temp.setEnMenu(t.isEnMenu());
			temp.setCategoriaManuf(t.getCategoriaManuf());
			temp.setDetalle(t.getDetalle());
			temp.setFoto(t.getFoto());
			temp.setPrecioM(t.getPrecioM());
			
			articuloManufacturadoRepository.save(temp);
			t.setId_artManuf(temp.getId_artManuf());

		} catch (Exception e) {
			System.out.println("No existe");
		}
		return t;
	}
	
	
	
	@Override
	public boolean delete(int id) {
		try {
			articuloManufacturadoRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
