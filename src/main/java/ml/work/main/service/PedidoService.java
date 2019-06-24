package ml.work.main.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ml.work.main.dtos.PedidoDTO;
import ml.work.main.entities.DetalleFactura;
import ml.work.main.entities.Pedido;
import ml.work.main.repositories.DetalleFacturaRepository;
import ml.work.main.repositories.PedidoRepository;

@Service
public class PedidoService implements ObjectService<PedidoDTO> {

	private PedidoRepository pedidoRepository;
	private DetalleFacturaRepository detalleFacturaRepository;
	

	public PedidoService(PedidoRepository pedidoRepository, DetalleFacturaRepository detalleFacturaRepository) {
		this.pedidoRepository = pedidoRepository;
		this.detalleFacturaRepository = detalleFacturaRepository;
	}
	
	@Override
	public ArrayList<PedidoDTO> getAll() {

		ArrayList<PedidoDTO> result = new ArrayList<>();

		for (Pedido pedido : pedidoRepository.findAll()) {
			PedidoDTO temp = new PedidoDTO();

			temp.setNumPedido(pedido.getNumPedido());
			temp.setTotal(pedido.getTotal());
			temp.setFecha(pedido.getFecha());
			temp.setHora(pedido.getHora());
			temp.setFechaAnulado(pedido.getFechaAnulado());
			temp.setObservaciones(pedido.getObservaciones());
			temp.setCliente(pedido.getCliente());
			temp.setEstadoListo(pedido.isEstadoListo());
			temp.setNombreTemporal(pedido.getNombreTemporal());
			temp.setDemora(pedido.getDemora());
			
			//Para traer todos los detalles del pedido en formato String
			String frase = "";		
			
			for (DetalleFactura detFactura : detalleFacturaRepository.findAll()) {
				if(detFactura.getPedido().getNumPedido() == pedido.getNumPedido()) {
					if(detFactura.getManufacturado() != null) {
						frase += detFactura.getCantidad()+" x "+detFactura.getManufacturado().getNombre_articuloM()+"\n";
					}else {
						frase += detFactura.getCantidad()+" x "+detFactura.getItem().getNombre_articulo()+"\n";
					}					 
				}
			}
			
			temp.setInforme(frase);

			result.add(temp);
		}
		return result;				
	}
	

	@Override
	public PedidoDTO getOne(int id) {		
		Optional<Pedido> temp = pedidoRepository.findById(id); // Optional: puede o no existir por ese Id. de no
																	// existir, no se crea el objeto
		PedidoDTO result = new PedidoDTO();

		try {

			Pedido resultBD = temp.get();

			result.setNumPedido(resultBD.getNumPedido());
			result.setTotal(resultBD.getTotal());
			result.setFecha(resultBD.getFecha());
			result.setHora(resultBD.getHora());
			result.setFechaAnulado(resultBD.getFechaAnulado());
			result.setObservaciones(resultBD.getObservaciones());
			result.setCliente(resultBD.getCliente());
			result.setEstadoListo(resultBD.isEstadoListo());
			result.setNombreTemporal(resultBD.getNombreTemporal());
			result.setDemora(resultBD.getDemora());

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return result;
	}

	@Override
	public PedidoDTO save(PedidoDTO body) {
		Pedido guardado = new Pedido();

		guardado.setFecha(body.getFecha());
		guardado.setHora(body.getHora());
		guardado.setTotal(body.getTotal());
		guardado.setFechaAnulado(body.getFechaAnulado());
		guardado.setObservaciones(body.getObservaciones());
		guardado.setCliente(body.getCliente());
		guardado.setNombreTemporal(body.getNombreTemporal());
		guardado.setEstadoListo(false);
		guardado.setDemora(0);

		try {
			pedidoRepository.save(guardado);
			body.setNumPedido(guardado.getNumPedido());
		} catch (Exception e) {
			System.out.println("Error al guardar");
		}
		return body;
	}

	@Override
	public PedidoDTO update(PedidoDTO t, int id) {
		Optional<Pedido> pOptional = pedidoRepository.findById(id);

		Pedido temp = new Pedido();

		try {
			temp = pOptional.get();

			temp.setFecha(t.getFecha());
			temp.setHora(t.getHora());
			temp.setTotal(t.getTotal());
			temp.setFechaAnulado(t.getFechaAnulado());
			temp.setObservaciones(t.getObservaciones());
			temp.setCliente(t.getCliente());
			temp.setNombreTemporal(t.getNombreTemporal());
			temp.setEstadoListo(t.isEstadoListo());
			temp.setDemora(t.getDemora());
		
			pedidoRepository.save(temp);
			t.setNumPedido(temp.getNumPedido());

		} catch (Exception e) {
			System.out.println("No existe");
		}
		return t;
	}

	@Override
	public boolean delete(int id) {
		try {
			pedidoRepository.deleteById(id);
		}catch (Exception e) {
			return false;
		}		
		return true;
	}

}
