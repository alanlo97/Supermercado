package supermercado;
import java.util.ArrayList;
import java.util.List;

import modelo.Carrito;
import modelo.Cliente;

import java.time.LocalDate;
import java.time.LocalTime;

public class AdmCarrito {
	private List<Carrito> lstCarrito = new ArrayList<Carrito>();

	public AdmCarrito(List<Carrito> lstCarrito) {
		super();
		this.lstCarrito = lstCarrito;
	}
	
	public AdmCarrito() {
		super();
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}
	
	@Override
	public String toString() {
		return "Lista Carritos: " + lstCarrito;
	}
	
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente)throws Exception {
		
		Carrito c = null;
		int index = 0;
		
		if(lstCarrito.isEmpty()) {
			c = new Carrito(1, fecha, hora, cliente);
		}else {
			while((c == null) && (index < lstCarrito.size())){
				if(hora == lstCarrito.get(index).getHora()) {
					throw new Exception ("EPAA, YA TENIAMOS ESTE CARRITO ATRODEN");
				}
				index++;
			}
			c = new Carrito(lstCarrito.get(lstCarrito.size()-1).getIdCarrito()+1, fecha, hora, cliente);
		}
		return lstCarrito.add(c);
	}
	
	public Carrito traerCarrito(int idCarrito) {
		
		Carrito c = null;
		int index = 0;
		
		while((c==null) && (index<lstCarrito.size())){
			if(lstCarrito.get(index).getIdCarrito() == idCarrito) {
				c = lstCarrito.get(index);
			}
			index++;
		}
		return c;
	}
	
	public Carrito traerItem(int idProducto) {
		
		//busca item en las listas de item
		
		Carrito c = null;
		int index = 0;
		
		while((c==null) && (index<lstCarrito.size())){
			//
			if(lstCarrito.get(index).traerItem(idProducto) != null) {
				c = lstCarrito.get(index);
			}
			index++;
		}
		return c;
	}

	public boolean eliminarCarrito(int idCarrito)throws Exception {
		if(traerCarrito(idCarrito) == null) {
			throw new Exception("NO HAY NINGUN PRODUCTO CON ESE ID BUUURRRRROOO");
		}
		return lstCarrito.remove(traerCarrito(idCarrito));
	}
}
