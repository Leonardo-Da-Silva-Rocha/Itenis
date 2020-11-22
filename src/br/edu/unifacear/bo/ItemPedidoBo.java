package br.edu.unifacear.bo;

import br.edu.unifacear.classes.ItemPedido;
import br.edu.unifacear.dao.ItemPedidoDao;

public class ItemPedidoBo {
	
	public void salvar(ItemPedido item) throws Exception {
		
		item.setPreco(item.getQuantidade() * item.getCalcado().getValor());
		
		try {
			new ItemPedidoDao().salvar(item);
		}catch(Exception e) {
			throw new Exception("Erro ao salvar o pedido");
		}
		
	}
	
	
	public void alterar(ItemPedido item) throws Exception {
		
		item.setPreco(item.getQuantidade() * item.getCalcado().getValor());
		
		try {
			new ItemPedidoDao().alterar(item);
		}catch(Exception e) {
			throw new Exception("Erro ao salvar o pedido");
		}
		
	}
}
