package br.edu.unifacear.classes;

import java.util.List;

import javax.persistence.*;

@Entity
public class TipoEntrega implements EntityBase {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idTipoEntrega;
	
	private String descricao;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "tipo")
	private List<Pedido> pedido;
	
	
	
	
	
	public void setIdTipoEntrega(int idTipoEntrega) {
		this.idTipoEntrega = idTipoEntrega;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Pedido> getPedido() {
		return pedido;
	}
	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	
	public TipoEntrega() {
		
	}
	public TipoEntrega(String descricao, List<Pedido> pedido) {
		
		this.descricao = descricao;
		this.pedido = pedido;
	}
	
	@Override
	public String toString() {
		return "TipoEntrega [descricao=" + descricao + ", pedido=" + pedido + "]";
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.idTipoEntrega;
	}
	
	
	
}
