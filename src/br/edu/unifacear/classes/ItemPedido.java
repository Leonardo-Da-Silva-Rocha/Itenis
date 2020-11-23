package br.edu.unifacear.classes;

import java.util.List;

import javax.persistence.*;

@Entity
public class ItemPedido implements EntityBase {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idItemPedido;
	
	private int quantidade;
	private Double preco;
	
	@ManyToOne
	private Calcado calcado;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "itemPedido")
	private List<Avaliacao> avaliacao;
	
	@ManyToOne
	private Pedido pedido;
	
	
	public int getIdItemPedido() {
		return idItemPedido;
	}
	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Calcado getCalcado() {
		return calcado;
	}
	public void setCalcado(Calcado calcado) {
		this.calcado = calcado;
	}
	public List<Avaliacao> getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(List<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public ItemPedido() {
		this.pedido = new Pedido();
		this.calcado = new Calcado();
	}
	public ItemPedido(int quantidade, Double preco, Calcado calcado, List<Avaliacao> avaliacao, Pedido pedido) {
		
		this.quantidade = quantidade;
		this.preco = preco;
		this.calcado = calcado;
		this.avaliacao = avaliacao;
		this.pedido = pedido;
	}
	
	@Override
	public String toString() {
		return "ItemPedido [quantidade=" + quantidade + ", preco=" + preco + ", calcado=" + calcado + ", avaliacao="
				+ avaliacao + ", pedido=" + pedido + "]";
	}
	@Override
	public int getId() {
		
		return this.idItemPedido;
	}
	
	
	
	
}
