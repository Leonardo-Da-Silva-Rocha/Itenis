package br.edu.unifacear.facade;

import br.edu.unifacear.bo.CarrinhoBo;
import br.edu.unifacear.classes.Carrinho;

public class CarrinhoFacade {
	
	private CarrinhoBo carrinhoBo;
	
	
	public CarrinhoFacade() {
		this.carrinhoBo = new CarrinhoBo();
	}
	
	public String criarCarrinho(Carrinho carrinho) throws Exception {
		
		this.carrinhoBo = new CarrinhoBo();
		this.carrinhoBo.Salvar(carrinho);
		
		return "Carrinho criado";
	}
	
}
