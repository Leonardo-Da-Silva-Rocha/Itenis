package br.edu.unifacear.facade;

import br.edu.unifacear.bo.ItemDoCarrinhoBo;
import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.classes.ItemDoCarrinho;

public class ItemCarrinhoFacade {
	
	
	private ItemDoCarrinhoBo item;
	
	
	public void ItemCarrinhoFacade() {
		this.item = new ItemDoCarrinhoBo();
	}
	
	
	public void adicionarProduto(ItemDoCarrinho item, Calcado calcado) throws Exception {
		this.item = new ItemDoCarrinhoBo();
		this.item.salvar(item, calcado.getQuantidade());
		
	}
}	
