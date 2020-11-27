package br.edu.unifacear.classes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido implements EntityBase {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int idPedido;

	private boolean status;
	private double preco;
	private String dataDeEntrega;

	@ManyToOne
	private Endereco endereco;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
	private List<ItemPedido> itemPedido;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private TipoEntrega tipo;

	@ManyToOne
	private Vendedor vendedor;

	private String formaPagamento;

	
	
	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

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

	public String getDataDeEntrega() {
		return dataDeEntrega;
	}

	public void setDataDeEntrega(String dataDeEntrega) {
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

	public Pedido(int idPedido, boolean status, double preco, String dataDeEntrega, Endereco endereco,
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
