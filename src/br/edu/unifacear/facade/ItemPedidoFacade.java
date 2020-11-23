package br.edu.unifacear.facade;

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
	
}