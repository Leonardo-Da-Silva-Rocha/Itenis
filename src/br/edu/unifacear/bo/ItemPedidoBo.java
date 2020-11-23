package br.edu.unifacear.bo;

import br.edu.unifacear.classes.ItemPedido;
import br.edu.unifacear.dao.GenericDao;


public class ItemPedidoBo {
	
	public void salvar(ItemPedido item) throws Exception {
		
		
		
		try {
			new GenericDao().saveOrUpdate(item);
		}catch(Exception e) {
			throw new Exception("Erro ao salvar o pedido");
		}
		
	}
	
	
}