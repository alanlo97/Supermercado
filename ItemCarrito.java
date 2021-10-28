package modelo;

public class ItemCarrito {
	private int idItem;
	private Producto producto;
	private int cantidad;
	public ItemCarrito(int idItem, Producto producto, int cantidad) {
		super();
		this.idItem = idItem;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public ItemCarrito(int idItem, Producto producto) {
		super();
		this.idItem = idItem;
		this.producto = producto;
	}
	
	
	public ItemCarrito( Producto producto) {
		super();
		this.producto = producto;
	}

	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return producto.toString() + ", cantidad: " + cantidad;
	}
	
	public boolean equals(Producto producto) {
		return (idItem == producto.getIdProducto()) && (producto.equals(this.producto));
	}
	
	public ItemCarrito createItem(Producto producto) {
		ItemCarrito item = new ItemCarrito(producto.getIdProducto(), producto);
		return item;
	}
	
}
