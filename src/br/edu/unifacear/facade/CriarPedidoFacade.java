package br.edu.unifacear.facade;

import br.edu.unifacear.bo.ItemPedidoBo;
import br.edu.unifacear.bo.PedidoBo;
import br.edu.unifacear.classes.ItemPedido;
import br.edu.unifacear.classes.Pedido;

public class CriarPedidoFacade {
	
	private PedidoBo pedidoBo;
	private ItemPedidoBo itemBo;
	
	public CriarPedidoFacade() {
		this.pedidoBo = new PedidoBo();
		this.itemBo = new ItemPedidoBo();
	}
	
	public void salvarPedido(Pedido pedido) throws Exception {
		this.pedidoBo = new PedidoBo();
		this.pedidoBo.salvar(pedido);
		
	}
	
	public void salvarItem(ItemPedido item) throws Exception {
		System.out.println("facade");
		this.itemBo = new ItemPedidoBo();
		this.itemBo.salvar(item);
	}
	
}