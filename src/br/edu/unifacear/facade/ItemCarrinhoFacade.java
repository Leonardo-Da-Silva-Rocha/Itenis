package br.edu.unifacear.facade;



import java.util.List;

import br.edu.unifacear.bo.ItemDoCarrinhoBo;
import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.ItemDoCarrinho;

public class ItemCarrinhoFacade {
	
	
	private ItemDoCarrinhoBo item;
	
	
	public ItemCarrinhoFacade() {
		this.item = new ItemDoCarrinhoBo();
	}
	
	
	public void adicionarProduto(ItemDoCarrinho item, Calcado calcado , Cliente cli) throws Exception {
		this.item = new ItemDoCarrinhoBo();
		this.item.salvar(item, calcado.getQuantidade(), cli);
		
	}
	
	public void alterar(ItemDoCarrinho item) throws Exception {
		this.item = new ItemDoCarrinhoBo();
		this.item.alterar(item);
	}
	

	public void remover(ItemDoCarrinho item) throws Exception {
		this.item = new ItemDoCarrinhoBo();
		this.item.remover(item);
	}
	
	public List<ItemDoCarrinho> listar(String pesquisa, ItemDoCarrinho item) throws Exception {
		this.item = new ItemDoCarrinhoBo();
		return this.item.listar(pesquisa, item);
	}
	
	public void excluirItemCarrinho(ItemDoCarrinho item) throws Exception {
		this.item = new ItemDoCarrinhoBo();
		this.item.readicionar(item);
	}
	
	public void zerarCarinho(List<ItemDoCarrinho> item) throws Exception {
		this.item = new ItemDoCarrinhoBo();
		this.item.removerItens(item);
	}
}	
