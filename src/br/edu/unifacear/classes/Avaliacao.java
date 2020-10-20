package br.edu.unifacear.classes;

import javax.persistence.*;

@Entity
public class Avaliacao {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idAvaliacao;
	
	private String comentario;
	private int avaliacao;
	
	@ManyToOne
	private ItemPedido itemPedido;

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Avaliacao() {
		
	}

	public Avaliacao(String comentario, int avaliacao, ItemPedido itemPedido) {
		
		this.comentario = comentario;
		this.avaliacao = avaliacao;
		this.itemPedido = itemPedido;
	}

	@Override
	public String toString() {
		return "Avaliacao [comentario=" + comentario + ", avaliacao=" + avaliacao + ", itemPedido=" + itemPedido + "]";
	}

	
	
	
}
