package modelo;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItem = new ArrayList<ItemCarrito>();
	private Cliente cliente;
	
	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, List<ItemCarrito> lstItem, Cliente cliente) {
		super();
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.lstItem = lstItem;
		this.cliente = cliente;
	}
	
	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
		super();
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
	}
	
	public int getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}
	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "fecha: " + fecha + ", hora: " + hora + ", lstItem: " + lstItem;
	}
	
	public boolean equals(Carrito c) {
		return (idCarrito == c.idCarrito) && (fecha == c.fecha) && (hora == c.hora) && (lstItem == c.lstItem);
	}
	
	public boolean agregarItem(Producto producto, int cantidad) {
		
		ItemCarrito item = null;
		int index = 0;
		boolean agregado = false;
		
		if(lstItem.isEmpty()) {
			item = new ItemCarrito(producto.getIdProducto(), producto, cantidad);
			agregado = lstItem.add(item);
		}else {
			while((item == null) && (index < lstItem.size())){
				if(lstItem.get(index).getProducto().equals(producto)) {
					lstItem.get(index).setCantidad(cantidad + lstItem.get(index).getCantidad());
					agregado = true;
				}
				index++;
			}
			if(agregado == false) {
				item = new ItemCarrito(producto.getIdProducto(), producto, cantidad);
				agregado = lstItem.add(item);
			}
		}
		return agregado;
	}
	
	public ItemCarrito traerItem(Producto producto) {
		
		ItemCarrito item = null;
		int index = 0;
		
		while((item==null) && (index<lstItem.size())){
			if(lstItem.get(index).getProducto().equals(producto)) {
				item = lstItem.get(index);
			}
			index++;
		}
		return item;
	}
	
	public ItemCarrito traerItem(int idProducto) {
		
		ItemCarrito item = null;
		int index = 0;
		
		while((item==null) && (index<lstItem.size())){
			if(lstItem.get(index).getIdItem() == idProducto) {
				item = lstItem.get(index);
			}
			index++;
		}
		return item;
	}
	
	public boolean eliminarItem(Producto producto, int cantidad)throws Exception {
		
		if(traerItem(producto) == null) {
			throw new Exception ("NO HAY NINGUN PRODUCTO CRUCK");
		}else {
			if(traerItem(producto).getCantidad() == cantidad) {
				lstItem.remove(traerItem(producto));
			}else {
				traerItem(producto).setCantidad(traerItem(producto).getCantidad() - cantidad);
			}
		}	
		return true;	
	}

}
