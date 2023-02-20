package Class;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private ArrayList<Producto> itemsPedido;
	
	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private List<String>pedido;
	private int tipo;
	
	
	public Pedido(String nombreCliente, String direccionCliente, List<String> pedido, int tipo) {
		this.idPedido = (int)(Math.random()*1000);
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.pedido = pedido;
		this.tipo = tipo;
	}
	
	public List<String> getPedido() {
		return pedido;
	}

	public void setPedido(List<String> pedido) {
		this.pedido = pedido;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public ArrayList<Producto> getItemsPedido() {
		return itemsPedido;
	}

	public void setItemsPedido(ArrayList<Producto> itemsPedido) {
		this.itemsPedido = itemsPedido;
	}

	public int getNumeroPedidos() {
		return numeroPedidos;
	}

	public void setNumeroPedidos(int numeroPedidos) {
		this.numeroPedidos = numeroPedidos;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	
	

}
