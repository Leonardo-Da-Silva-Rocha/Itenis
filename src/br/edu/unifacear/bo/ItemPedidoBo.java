package br.edu.unifacear.bo;



import java.util.List;

import br.edu.unifacear.classes.ItemPedido;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.dao.ItemPedidoDao;



public class ItemPedidoBo {

	public void salvar(ItemPedido item) throws Exception {

		try {
			new GenericDao().saveOrUpdate(item);
		} catch (Exception e) {
			throw new Exception("Erro ao salvar o pedido");
		}

	}

	public List<ItemPedido> listar(int id) throws Exception {
		try {
			return new ItemPedidoDao().listar(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
