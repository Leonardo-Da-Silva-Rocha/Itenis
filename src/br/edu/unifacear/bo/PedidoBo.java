package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.ItemDoCarrinho;
import br.edu.unifacear.classes.Pedido;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.dao.PedidoDao;

public class PedidoBo {

	public Pedido valorTotalDoPedido(Pedido pedido) {

		for (int i = 0; i < pedido.getItemPedido().size(); i++) {

			pedido.setPreco(pedido.getPreco() + pedido.getItemPedido().get(i).getPreco());

		}

		return pedido;

	}

	public List<Pedido> listar(String pesquisa, int id) throws Exception {

		try {
			return new PedidoDao().listar(pesquisa, id);
		} catch (Exception e) {
			throw new Exception("Erro ao listar");
		}

	}

	public void salvar(Pedido pedido) throws Exception {

		if (pedido.isStatus() == true) {
			validarPedido(pedido);
		}
		try {
			new GenericDao().saveOrUpdate(pedido);
		} catch (Exception e) {
			throw new Exception("Erro ao salvar pedido");
		}

	}

	public void validarPedido(Pedido pedido) throws Exception {

		for (ItemDoCarrinho item : pedido.getCliente().getCarrinho().getItem()) {
			if (item.getQuantidade() == 0) {
				System.out.println("nao finalizou");
				throw new Exception("Erro ao Finalizar pedido selecione uma quantidade de produto");
			}
		}

		if (pedido.getFormaPagamento().equals("")) {
			System.out.println("erro bo pedido");
			throw new Exception("Erro ao Finalizar pedido selecione uma forma de pagamento");
		}

	}

}