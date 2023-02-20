package Class;

import java.util.ArrayList;


public class Combo extends Producto{
	

	private String nombre;
	private int descuento;
	private ArrayList<String> itemsCombo;
	private ArrayList<ProductoMenu> itemCombo;

	
	
	public Combo (String nombre, int descuento, ArrayList<String> itemsCombo) {
		
		this.nombre = nombre;
		this.descuento = descuento;
		this.itemsCombo = itemsCombo;
		
	}
	
	public double getPrecio(String nombre, int descuento) {
		
		String [] lista = nombre.split("combo ");
		double precioFinal = 0.0;
		
		for (ProductoMenu p: itemCombo) {
			if (lista[0] == p.getNombre()) {
				int precio = p.getPrecioBase();
				precioFinal = precio*(100 - (descuento/100));
			}
		}
		return precioFinal;
	}


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getDescuento() {
		return descuento;
	}



	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}



	public ArrayList<String> getItemsCombo() {
		return itemsCombo;
	}



	public void setItemsCombo(ArrayList<String> itemsCombo) {
		this.itemsCombo = itemsCombo;
	}

	public String generarTextoFactura() {
		return null;
	}
	
	
	
	
	
}
