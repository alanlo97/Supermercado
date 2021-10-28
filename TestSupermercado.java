package test;

import java.time.LocalDate;
import java.time.LocalTime;

import supermercado.Supermercado;

public class TestSupermercado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Supermercado chinoArg = new Supermercado();
		
		System.out.println("AGREGANDO PRODUCTO A LA GONDOLA\n");
		
		try {
			chinoArg.agregarProducto("Coca", 19.3f);
			chinoArg.agregarProducto("Fideos", 152.1f);
			chinoArg.agregarProducto("Jabon", 58.6f);
			chinoArg.agregarProducto("Galletitas", 89.5f);
			chinoArg.agregarProducto("Huevos", 820.3f);
			System.out.println(chinoArg.getAmdProducto().toString());
		}catch(Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		System.out.println("\nQUERIENDO AGREGAR UN PRODUCTO YA AGREGADO\n");
		
		try {
			chinoArg.agregarProducto("Coca", 19.3f);
		}catch(Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		System.out.println("\nELIMANDO PRODUCTO\n");
		
		try {
			chinoArg.eliminarProducto(3);
			System.out.println(chinoArg.getAmdProducto().toString());
		}catch(Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		System.out.println("\nQUERIENDO ELIMINAR UN PRODUCTO NO EXISTENTE\n");
		
		try {
			chinoArg.eliminarProducto(3);
			System.out.println(chinoArg.getAmdProducto().toString());
		}catch(Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		System.out.println("\nCARGANDO CLIENTES\n");
		
		try {
			chinoArg.agregarCliente("Barassi", 35126550, "Las Toninas 132");
			//chinoArg.agregarCliente("Leopoldo", 123456789, "El Verdad 121");
			chinoArg.agregarCliente("Lionel", 3264541, "Paris 36");
			chinoArg.agregarCliente("Roman", 6524710, "Brandsen 176");
			//chinoArg.agregarCliente("Jesus", 12056189, "Israel 714");
			System.out.println(chinoArg.getAmdCliente().toString());
		}catch(Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		System.out.println("\nDUPLICAR UN CLIENTE\n");
		
		try {
			chinoArg.agregarCliente("Barassi", 35126550, "Las Toninas 132");
			System.out.println(chinoArg.getAmdCliente().toString());
		}catch(Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		try {
			chinoArg.agregarCarrito(LocalDate.now(), LocalTime.now(), chinoArg.traerCliente(0));
		}catch(Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		System.out.println("\nAGREGANDO PRODUCTOS AL CHANGUITO\n");
		
		chinoArg.getAmdCarrito().getLstCarrito().get(0).agregarItem(chinoArg.getAmdProducto().getLstProducto().get(0), 4);
		chinoArg.getAmdCarrito().getLstCarrito().get(0).agregarItem(chinoArg.getAmdProducto().getLstProducto().get(1), 1);
		//chinoArg.getAmdCarrito().getLstCarrito().get(0).agregarItem(chinoArg.getAmdProducto().getLstProducto().get(2), 2);
		chinoArg.getAmdCarrito().getLstCarrito().get(0).agregarItem(chinoArg.getAmdProducto().getLstProducto().get(3), 1);
		System.out.println(chinoArg.getAmdCarrito().toString());
		
		System.out.println("\nCAMBIANDO LA CANTIDAD DEL FERNET\n");
		
		chinoArg.getAmdCarrito().getLstCarrito().get(0).agregarItem(chinoArg.getAmdProducto().getLstProducto().get(3), 5);
		System.out.println(chinoArg.getAmdCarrito().toString());
		
	}

}
