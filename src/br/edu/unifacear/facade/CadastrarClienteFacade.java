package br.edu.unifacear.facade;

import br.edu.unifacear.bo.ClienteBo;
import br.edu.unifacear.bo.EnderecoBo;
import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.Endereco;

public class CadastrarClienteFacade {
	
	private ClienteBo clienteBo;
	private EnderecoBo enderecoBo;
	
	public CadastrarClienteFacade() {
		this.clienteBo = new ClienteBo();
		this.enderecoBo = new EnderecoBo();
	}
	
	
	public void salvar(Endereco endereco, Cliente cliente) throws Exception {
		
			this.clienteBo.validar(cliente);
			
			this.enderecoBo.salvar(endereco);
		
			this.clienteBo.salvarValidar(cliente);
			
		
	}
	
}
