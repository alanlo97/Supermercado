package supermercado;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Carrito;
import modelo.Cliente;
import modelo.Producto;

public class Supermercado {
	private AdmProducto amdProducto = new AdmProducto();
	private AdmCliente amdCliente = new AdmCliente();
	private AdmCarrito amdCarrito = new AdmCarrito();
	
	public Supermercado(AdmProducto amdProducto, AdmCliente amdCliente, AdmCarrito amdCarrito) {
		super();
		this.amdProducto = amdProducto;
		this.amdCliente = amdCliente;
		this.amdCarrito = amdCarrito;
	}
	
	public Supermercado() {
		super();
	}

	public AdmProducto getAmdProducto() {
		return amdProducto;
	}

	public void setAmdProducto(AdmProducto amdProducto) {
		this.amdProducto = amdProducto;
	}

	public AdmCliente getAmdCliente() {
		return amdCliente;
	}

	public void setAmdCliente(AdmCliente amdCliente) {
		this.amdCliente = amdCliente;
	}

	public AdmCarrito getAmdCarrito() {
		return amdCarrito;
	}

	public void setAmdCarrito(AdmCarrito amdCarrito) {
		this.amdCarrito = amdCarrito;
	}

	//-----------------------------------------------------------------
	//-----------------------------------------------------------------
	
	public boolean agregarProducto(String producto, float precio)throws Exception {	
		return amdProducto.agregarProducto(producto, precio);
	}
	
	public Producto traerProducto(int idProducto) {
		return amdProducto.traerProducto(idProducto);
	}
	
	public boolean modificarProducto(int idProducto, String producto, float precio)throws Exception {
		return amdProducto.modificarProducto(idProducto, producto, precio);
	}
	
	public boolean eliminarProducto(int idProducto)throws Exception {
		if((amdProducto.traerProducto(idProducto) == null) && (amdCarrito.traerItem(idProducto) != null)) {
			throw new Exception("EL PRODUCTO NO EXISTE O ESTA EN UN CARRITO INFELI'");
		}
		return amdProducto.eliminarProducto(idProducto);
	}
	
	//-----------------------------------------------------------------
	//-----------------------------------------------------------------
	
	public boolean agregarCliente(String cliente, long dni, String direccion)throws Exception{
		return amdCliente.agregarCliente(cliente, dni, direccion);
	}
	
	public Cliente traerCliente(int idCliente) {
		return amdCliente.traerCliente(idCliente);
	}

	public boolean eliminarCliente(int idCliente)throws Exception {
		return amdCliente.eliminarCliente(idCliente);
	}
	
	//-----------------------------------------------------------------
	//-----------------------------------------------------------------
	
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente)throws Exception {
		return amdCarrito.agregarCarrito(fecha, hora, cliente);
	}
	
	public Carrito traerCarrito(int idCarrito) {
		return amdCarrito.traerCarrito(idCarrito);
	}

	public boolean eliminarCarrito(int idCarrito)throws Exception {
		return amdCarrito.eliminarCarrito(idCarrito);
	}
	
}
