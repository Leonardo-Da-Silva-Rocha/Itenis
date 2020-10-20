package br.edu.unifacear.classes;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
@Entity
public class Pedido implements EntityBase {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int idPedido;
	
	private boolean status;
	private double preco;
	private Date dataDeEntrega;
	
	@ManyToOne
	private Endereco endereco;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "pedido")
	private List<ItemPedido> itemPedido;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private TipoEntrega tipo;
	
	@ManyToOne
	private Vendedor vendedor;
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public Date getDataDeEntrega() {
		return dataDeEntrega;
	}
	public void setDataDeEntrega(Date dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}
	
	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public TipoEntrega getTipo() {
		return tipo;
	}
	public void setTipo(TipoEntrega tipo) {
		this.tipo = tipo;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Pedido() {
		
	}
	
	
	public Pedido(int idPedido, boolean status, double preco, Date dataDeEntrega, Endereco endereco,
			List<ItemPedido> itemPedido, Cliente cliente, TipoEntrega tipo, Vendedor vendedor) {
		
		this.idPedido = idPedido;
		this.status = status;
		this.preco = preco;
		this.dataDeEntrega = dataDeEntrega;
		this.endereco = endereco;
		this.itemPedido = itemPedido;
		this.cliente = cliente;
		this.tipo = tipo;
		this.vendedor = vendedor;
	}
	
	
	
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", status=" + status + ", preco=" + preco + ", dataDeEntrega="
				+ dataDeEntrega + ", endereco=" + endereco + ", itemPedido=" + itemPedido + ", cliente=" + cliente
				+ ", tipo=" + tipo + ", vendedor=" + vendedor + "]";
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.idPedido;
	}
	
	
	
}
