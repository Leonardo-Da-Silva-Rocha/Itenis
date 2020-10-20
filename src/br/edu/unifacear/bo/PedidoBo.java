package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Pedido;
import br.edu.unifacear.dao.PedidoDao;

public class PedidoBo {
	
	public Pedido valorTotalDoPedido(Pedido pedido) {
		
		for (int i = 0; i < pedido.getItemPedido().size(); i++) {
			
			pedido.setPreco(pedido.getPreco() + pedido.getItemPedido().get(i).getPreco());
			
		}
		
		return pedido;
		
		
	}
	
	public List<Pedido> listar(String pesquisa, Pedido pedido) throws Exception{
		
		try {
			return new PedidoDao().listar(pesquisa, pedido);
		}catch(Exception e) {
			throw new Exception("Erro ao listar");
		}
		
	}
	
}
