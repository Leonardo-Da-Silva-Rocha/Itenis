package br.edu.unifacear.facade;

import br.edu.unifacear.bo.ClienteBo;
import br.edu.unifacear.classes.Cliente;

public class ClienteFacade {
	
	private ClienteBo clienteBo;
	
	
	public ClienteFacade() {
		this.clienteBo = new ClienteBo();
	}
	
	
	
	
	public void inserirCliente(Cliente cliente) throws Exception {
		this.clienteBo = new ClienteBo();
		this.clienteBo.salvarValidar(cliente);
	}
	
	public void login(Cliente cliente) throws Exception {
		this.clienteBo = new ClienteBo();
		this.clienteBo.logar(cliente);
	}
	
	
}
