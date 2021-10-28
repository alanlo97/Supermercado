package supermercado;
import java.util.List;

import modelo.Producto;

import java.util.ArrayList;

public class AdmProducto {
	private List<Producto> lstProducto = new ArrayList<Producto>();

	public AdmProducto(List<Producto> lstProducto) {
		super();
		this.lstProducto = lstProducto;
	}
	
	public AdmProducto() {
		super();
	}

	public List<Producto> getLstProducto() {
		return lstProducto;
	}

	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}
	
	@Override
	public String toString() {
		return "Lista Productos: " + lstProducto;
	}

	public boolean agregarProducto(String producto, float precio)throws Exception {
		
		Producto p = null;
		int index = 0;
		
		if(lstProducto.isEmpty()) {
			p = new Producto(1, producto, precio);
		}else {
			while((p == null) && (index < lstProducto.size())){
				if(producto.equalsIgnoreCase(lstProducto.get(index).getProducto())) {
					throw new Exception ("EL PRODUCTO YA ESTA EN LA GONDOLA INFELI'");
				}
				index++;
			}
			p = new Producto(lstProducto.get(lstProducto.size()-1).getIdProducto()+1, producto, precio);
		}
		return lstProducto.add(p);		
	}
	
	public Producto traerProducto(int idProducto) {
		
		Producto p = null;
		int index = 0;
		
		while((p==null) && (index<lstProducto.size())){
			if(lstProducto.get(index).getIdProducto() == idProducto) {
				p = lstProducto.get(index);
			}
			index++;
		}
		return p;
	}
	
	public boolean modificarProducto(int idProducto, String producto, float precio)throws Exception {
		if(traerProducto(idProducto) == null) {
			throw new Exception("NO HAY NINGUN PRODUCTO CON ESE ID BUUURRRRROOO");
		}
		traerProducto(idProducto).setProducto(producto);
		traerProducto(idProducto).setPrecio(precio);
		
		return true;
	}
	
	public boolean eliminarProducto(int idProducto)throws Exception {
		if(traerProducto(idProducto) == null) {
			throw new Exception("NO HAY NINGUN PRODUCTO CON ESE ID BUUURRRRROOO");
		}
		return lstProducto.remove(traerProducto(idProducto));
	}
	
}
