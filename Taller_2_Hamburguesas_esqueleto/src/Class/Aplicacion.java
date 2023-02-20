package Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class Aplicacion {
	
	private static Restaurante restaurante;
	private static ProductoMenu productoMenu;
	
	public static void main(String[] args) {
		
		Restaurante restaurantel = new Restaurante();
		restaurante = restaurantel;
		new Aplicacion();

	}
	
	public void mostrarMenu() {
		
		System.out.println("Ingrese la opcion que desee:");
		System.out.println("1- Cargar informacion restaurante");
		System.out.println("2- Iniciar pedido");
	}
	
	public Aplicacion() {
		
		boolean continuar = true;
		while (continuar) {
			
			mostrarMenu();
			int opcion = Integer.parseInt(input("Por favor seleccione una opción"));
			
			if (opcion == 1)
				ejecutarCarga();
			else if (opcion == 2 && restaurante != null)
				ejecutarPedido();
			else if (opcion == 3) {
				System.out.println("Saliendo de la aplicación ...");
				continuar = false;
			}
			else if (restaurante == null) {
				System.out.println("Para poder ejecutar esta opción primero debe cargar un archivo de atletas.");
			}
			else {
				System.out.println("Por favor seleccione una opción válida.");
			}
		}
	}
	
	private void ejecutarCarga() {
		
		try {
			restaurante.CargarInformacionRestaurante();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
	}
	
	public void ejecutarPedido() {
		
		restaurante.getMenuBase();
		ArrayList<ProductoMenu> menuBase = restaurante.getMenuBase();
		for (ProductoMenu p: menuBase) {
			String nombre = p.getNombre();
			System.out.println(nombre);
		}
		String opcion = input("Por favor escriba el producto que quiere comprar.");
		List <String> pedido = new ArrayList <String>();
		pedido.add(opcion);
		int tipo2 = 2;
		int tipo = Integer.parseInt(input("Escriba 1 si quiere añadir o elminar ingredientes, sino escriba 2(los combos no pueden añadir o quitar ingredientes)"));
		System.out.println(tipo);
		String falso = "2";
		
		while(tipo == 1) {
			String nuevo = input("Escriba un producto que va a agragar, de lo contrario escriba <2>:");
			if (nuevo != falso){
				pedido.add(nuevo + ",A");
				}
			else {
				break;
			}
			
		}
		while(tipo2 == 1) {
			String nuevo = input("Escriba un producto que va a eliminar, de lo contrario escriba <2>:");
			if (nuevo != "2") {
				pedido.add(nuevo + ",E");
				}
			else {
				break;
			}
			
		}
		String nombre = input("Por favor escriba su nombre:");
		String direccion = input("Por favor escriba su direccion:");
		restaurante.iniciarPedido(nombre, direccion, pedido, tipo);
	}
	
	

	
	public String input(String mensaje) {
		try {
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e) {
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		
		return null;
	}
}
