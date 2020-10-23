package br.edu.unifacear.facade;

import br.edu.unifacear.bo.EnderecoBo;
import br.edu.unifacear.classes.Endereco;

public class EnderecoFacade {
	
	
	private EnderecoBo enderecoBo;
	
	public EnderecoFacade() {
		this.enderecoBo = new EnderecoBo();
	}
	
	public void salvar(Endereco endereco) throws Exception {
		this.enderecoBo = new EnderecoBo();
		this.enderecoBo.salvar(endereco);
	}
	
}
