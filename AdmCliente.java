package supermercado;
import java.util.List;

import modelo.Cliente;

import java.util.ArrayList;

public class AdmCliente {
	private List<Cliente> lstCliente = new ArrayList<Cliente>();

	public AdmCliente(List<Cliente> lstCliente) {
		super();
		this.lstCliente = lstCliente;
	}
	
	public AdmCliente() {
		super();
	}

	public List<Cliente> getLstCliente() {
		return lstCliente;
	}

	public void setLstCarrito(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}
	
	@Override
	public String toString() {
		return "Lista Clientes: " + lstCliente;
	}
	
	public boolean agregarCliente(String cliente, long dni, String direccion)throws Exception {
		
		Cliente c = null;
		int index = 0;
		
		if(lstCliente.isEmpty()) {
			c = new Cliente(1, cliente, dni, direccion);
		}else {
			while((c == null) && (index < lstCliente.size())){
				if(dni == lstCliente.get(index).getDni()) {
					throw new Exception ("CUANTAS VECES VAS A VENIR A COMPRAR?");
				}
				index++;
			}
			c = new Cliente(lstCliente.get(lstCliente.size()-1).getIdCliente()+1, cliente, dni, direccion);
		}
		return lstCliente.add(c);		
	}
		
	public Cliente traerCliente(int idCliente) {
		
		Cliente c = null;
		int index = 0;
		
		while((c==null) && (index<lstCliente.size())){
			if(lstCliente.get(index).getIdCliente() == idCliente) {
				c = lstCliente.get(index);
			}
			index++;
		}
		return c;
	}

	public boolean eliminarCliente(int idCliente)throws Exception {
		if(traerCliente(idCliente) == null) {
			throw new Exception("NO HAY NINGUN PRODUCTO CON ESE ID BUUURRRRROOO");
		}
		return lstCliente.remove(traerCliente(idCliente));
	}
	
}
