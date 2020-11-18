package br.edu.unifacear.facade;



import java.util.List;

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
	
	public List<Carrinho> listar(int idCliente) throws Exception {
		this.carrinhoBo = new CarrinhoBo();
		return this.carrinhoBo.listar("exibirCarrinhoCliente", new Carrinho(), idCliente);
	}
	
}
