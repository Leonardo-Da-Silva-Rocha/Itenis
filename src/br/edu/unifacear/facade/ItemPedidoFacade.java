package br.edu.unifacear.facade;

import java.util.List;

import br.edu.unifacear.bo.ItemPedidoBo;
import br.edu.unifacear.classes.ItemPedido;

public class ItemPedidoFacade {

	private ItemPedidoBo itemPedidoBo;

	public ItemPedidoBo getItemPedidoBo() {
		return itemPedidoBo;
	}

	public void setItemPedidoBo(ItemPedidoBo itemPedidoBo) {
		this.itemPedidoBo = itemPedidoBo;
	}

	public ItemPedidoFacade() {
		this.itemPedidoBo = new ItemPedidoBo();
	}
	
	public void salvar(ItemPedido item) throws Exception {
		
		this.itemPedidoBo = new ItemPedidoBo();
		this.itemPedidoBo.salvar(item);
	}
	
	public List<ItemPedido> listar(int id) throws Exception{
		this.itemPedidoBo = new ItemPedidoBo();
		return this.itemPedidoBo.listar(id);
	}
	
}