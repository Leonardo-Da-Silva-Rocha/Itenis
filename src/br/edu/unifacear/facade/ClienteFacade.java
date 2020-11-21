package br.edu.unifacear.facade;



import java.util.List;

import br.edu.unifacear.bo.CarrinhoBo;
import br.edu.unifacear.bo.ClienteBo;
import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.classes.Cliente;

public class ClienteFacade {
	
	private ClienteBo clienteBo;
	private CarrinhoBo carrinhoBo;
	
	public ClienteFacade() {
		this.clienteBo = new ClienteBo();
		this.carrinhoBo = new CarrinhoBo();
	}
	
	
	
	
	public void inserirCliente(Cliente cliente) throws Exception {
		this.clienteBo = new ClienteBo();
		this.clienteBo.salvarValidar(cliente);
	}
	
	public void login(Cliente cliente) throws Exception {
		this.clienteBo = new ClienteBo();
		this.clienteBo.logar(cliente);
	}
	
	public List<Carrinho> carrinho(Cliente cliente) throws Exception {
		return this.carrinhoBo.listar("exibirCarrinhoCliente", cliente.getCarrinho(), cliente.getIdCliente());
		
	}
	
	public List<Cliente> listar(String pesquisa, Cliente cliente) throws Exception{
		return this.clienteBo.listar(pesquisa, cliente);
	}




	
	
	
	
}
