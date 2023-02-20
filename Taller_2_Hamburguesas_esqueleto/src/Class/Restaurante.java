package Class;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Restaurante {

	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<ProductoMenu> menuBase;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Combo> combo;
	private ArrayList <Pedido> pedidoEnCurso;	
	
	
	
	
	
	public void getPedidoEnCurso() {
		
	}
	
	public ArrayList<ProductoMenu> getMenuBase() {
		return menuBase;
	}
	
	public ArrayList<Ingrediente> getIngredients(){
		return ingredientes;
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente, List<String> pedido, int tipo) {
		
		Pedido nuevo = new Pedido(nombreCliente, direccionCliente, pedido, tipo);
		
		
		
		
		pedidos.add(nuevo);
		
		
				
		
		
	}

	
	public void cerrarYGuardarPedido() {
		
	}
	
	
	public void CargarInformacionRestaurante() throws IOException {
		
		menuBase = new ArrayList <ProductoMenu>();
		ingredientes = new ArrayList <Ingrediente>();
		combo = new ArrayList <Combo>();
		
		Cargar("./data/menu.txt", 1);
		Cargar("./data/ingredientes.txt", 2);
		Cargar("./data/combos.txt", 3);
		
	}
	
	private void Cargar(String nombre, int tipo) throws IOException {
		File archivo = new File(nombre);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		while(linea!=null) {

			String [] datos = linea.split(";");
			
			if (tipo == 1) {
				
				String producto = datos[0];
				int precio = Integer.parseInt(datos[1]);
				
				ProductoMenu total = new ProductoMenu(producto, precio);
				menuBase.add(total);
				
			}
			
			else if (tipo == 2) {
				
				String producto = datos[0];
				int precio = Integer.parseInt(datos[1]);
				
				Ingrediente total = new Ingrediente(producto, precio);
				ingredientes.add(total);
				
			}
			
			else if (tipo == 3) {
				
				String nomCombo = datos[0];
				int descuento = Integer.parseInt(datos[1].replaceAll("%", ""));
				String ing_1 = datos[2];
				String ing_2 = datos[3];
				String ing_3 = datos[4];
				
				ArrayList<String> itemsCombo = new ArrayList <String>();
				itemsCombo.add(ing_1);
				itemsCombo.add(ing_2);
				itemsCombo.add(ing_3);
				
				Combo total = new Combo(nomCombo, descuento, itemsCombo);
				combo.add(total);
					
			}
			
			linea = lector.readLine();
		}
		lector.close();
	}
	
}
