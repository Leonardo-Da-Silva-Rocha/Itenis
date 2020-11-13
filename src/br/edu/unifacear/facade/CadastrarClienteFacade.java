package br.edu.unifacear.facade;



import br.edu.unifacear.bo.CarrinhoBo;
import br.edu.unifacear.bo.ClienteBo;
import br.edu.unifacear.bo.EnderecoBo;
import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.Endereco;

public class CadastrarClienteFacade {
	
	private ClienteBo clienteBo;
	private EnderecoBo enderecoBo;
	private CarrinhoBo carrinhoBo;
	
	public CadastrarClienteFacade() {
		this.clienteBo = new ClienteBo();
		this.enderecoBo = new EnderecoBo();
		this.carrinhoBo = new CarrinhoBo();
	}
	
	public void salvar(Endereco endereco, Cliente cliente, Carrinho carrinho) throws Exception {
		
			this.clienteBo.validar(cliente);
			
			this.enderecoBo.salvar(endereco);
			
			this.clienteBo.salvarValidar(cliente);
			
			carrinho.setCliente(cliente);
			
			this.carrinhoBo.Salvar(carrinho);
		
	}
	
}
