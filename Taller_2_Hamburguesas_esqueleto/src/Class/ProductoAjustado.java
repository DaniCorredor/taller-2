package Class;

import java.util.ArrayList;

public class ProductoAjustado {

	private ArrayList<Ingrediente> agregados;
	private ArrayList <Ingrediente> eliminados;
	private ProductoMenu base;
	
	

	public ProductoAjustado(ProductoMenu base) {
		
		this.base = base;
		
	}
	
	public String getNombre(String nombre) {
		return nombre;
	}
	
	public int getPrecio(String nombre) {
		int preAgregado = 0;
		int preEliminado = 0;
		
		for (Ingrediente i: agregados) {
			if (nombre == i.getNombre()) {
				preAgregado = i.getCostoAdicional();
			}
		}
		for (Ingrediente i: eliminados) {
			if (nombre == i.getNombre()) {
				preEliminado = i.getCostoAdicional();
			}
		}
	int precio = preAgregado - preEliminado;
	
	return precio;
		
	}
	
	public void generarTextoFactura() {
		
	}
}
