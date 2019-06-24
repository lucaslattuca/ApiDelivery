package ml.work.main.service;

import java.util.ArrayList; 
import java.util.Optional;

import org.springframework.stereotype.Service;

import ml.work.main.dtos.DetalleFacturaDTO;
import ml.work.main.entities.DetalleFactura;
import ml.work.main.repositories.DetalleFacturaRepository;

@Service
public class DetalleFacturaService implements ObjectService<DetalleFacturaDTO> {

	private DetalleFacturaRepository detalleFacturaRepository;

	public DetalleFacturaService(DetalleFacturaRepository detalleFacturaRepository) {
		this.detalleFacturaRepository = detalleFacturaRepository;
	}

	@Override
	public ArrayList<DetalleFacturaDTO> getAll() {

		ArrayList<DetalleFacturaDTO> result = new ArrayList<>();

		for (DetalleFactura detFactura : detalleFacturaRepository.findAll()) {
			DetalleFacturaDTO temp = new DetalleFacturaDTO();

			temp.setCantidad(detFactura.getCantidad());
			temp.setIdDetalle(detFactura.getIdDetalle());
			temp.setSubtotal(detFactura.getSubtotal());
			temp.setPedido(detFactura.getPedido());
			temp.setItem(detFactura.getItem());
			temp.setManufacturado(detFactura.getManufacturado());
			temp.setFechaAnulado(detFactura.getFechaAnulado());

			result.add(temp);
		}

		return result;
	}
	
	
	//Método que trae todos los detalles correspondientes a un pedido
	public ArrayList<DetalleFacturaDTO> getXPedido(int idPedido) {

		ArrayList<DetalleFacturaDTO> result = new ArrayList<>();

		for (DetalleFactura detFactura : detalleFacturaRepository.findAll()) {
			DetalleFacturaDTO temp = new DetalleFacturaDTO();
			
			if(detFactura.getPedido().getNumPedido() == idPedido) {
				temp.setCantidad(detFactura.getCantidad());
				temp.setIdDetalle(detFactura.getIdDetalle());
				temp.setSubtotal(detFactura.getSubtotal());
				temp.setPedido(detFactura.getPedido());
				temp.setItem(detFactura.getItem());
				temp.setManufacturado(detFactura.getManufacturado());
				temp.setFechaAnulado(detFactura.getFechaAnulado());

				result.add(temp);
			}			
		}
		return result;
	}
	

	@Override
	public DetalleFacturaDTO getOne(int id) {
		Optional<DetalleFactura> temp = detalleFacturaRepository.findById(id); 
		
		DetalleFacturaDTO result = new DetalleFacturaDTO();

		try {

			DetalleFactura resultBD = temp.get();

			result.setIdDetalle(resultBD.getIdDetalle());
			result.setCantidad(resultBD.getCantidad());
			result.setSubtotal(resultBD.getSubtotal());
			result.setPedido(resultBD.getPedido());
			result.setItem(resultBD.getItem());
			result.setManufacturado(resultBD.getManufacturado());
			result.setFechaAnulado(resultBD.getFechaAnulado());

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return result;
	}

	@Override
	public DetalleFacturaDTO save(DetalleFacturaDTO body) {
		DetalleFactura guardado = new DetalleFactura();

		guardado.setCantidad(body.getCantidad());
		guardado.setSubtotal(body.getSubtotal());
		guardado.setPedido(body.getPedido());
		guardado.setItem(body.getItem());
		guardado.setManufacturado(body.getManufacturado());
		guardado.setFechaAnulado(body.getFechaAnulado());
		
		try {
			detalleFacturaRepository.save(guardado);
			body.setIdDetalle(guardado.getIdDetalle());
		} catch (Exception e) {
			System.out.println("Error al guardar");
		}
		return body;
	}

	@Override
	public DetalleFacturaDTO update(DetalleFacturaDTO t, int id) {
		Optional<DetalleFactura> pOptional = detalleFacturaRepository.findById(id);

		DetalleFactura temp = new DetalleFactura();

		try {
			temp = pOptional.get();

			temp.setCantidad(t.getCantidad());
			temp.setSubtotal(t.getSubtotal());
			temp.setPedido(t.getPedido());
			temp.setItem(t.getItem());
			temp.setManufacturado(t.getManufacturado());
			temp.setFechaAnulado(t.getFechaAnulado());
		
			detalleFacturaRepository.save(temp);
			t.setIdDetalle(temp.getIdDetalle());

		} catch (Exception e) {
			System.out.println("No existe");
		}
		return t;
	}

	@Override
	public boolean delete(int id) {
		try {
			detalleFacturaRepository.deleteById(id);
		}catch (Exception e) {
			return false;
		}		
		return true;
	}

}
