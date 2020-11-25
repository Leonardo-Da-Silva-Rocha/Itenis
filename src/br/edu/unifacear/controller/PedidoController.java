package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Endereco;
import br.edu.unifacear.classes.ItemPedido;
import br.edu.unifacear.classes.Pedido;
import br.edu.unifacear.classes.TipoEntrega;
import br.edu.unifacear.facade.TipoEntregaFacade;

@ManagedBean(name = "pedidoBean")
@RequestScoped
public class PedidoController {

	private Endereco endereco;
	private Pedido pedido;
	private TipoEntrega tipoEntrega;
	private List<TipoEntrega> tipos;
	private List<ItemPedido> itens;
	private List<Pedido> pedidos;
	private ItemPedido item;

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ItemPedido getItem() {
		return item;
	}

	public void setItem(ItemPedido item) {
		this.item = item;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public List<TipoEntrega> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoEntrega> tipos) {
		this.tipos = tipos;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public TipoEntrega getTipoEntrega() {
		return tipoEntrega;
	}

	public void setTipoEntrega(TipoEntrega tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	public PedidoController() {
		this.endereco = new Endereco();
		this.item = new ItemPedido();
		this.itens = new ArrayList<>();
		this.tipos = new ArrayList<>();
		this.pedido = new Pedido();
		this.tipoEntrega = new TipoEntrega();
		carregarCombo();

	}

	public void finalizar() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			System.out.println(this.item.getId() + "skad");

		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

	}

	public void carregarCombo() {
		FacesContext context = FacesContext.getCurrentInstance();
		TipoEntregaFacade facade = new TipoEntregaFacade();
		try {

			this.tipos = facade.listar("todos", new TipoEntrega());

		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

	}

}
