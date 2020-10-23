package br.edu.unifacear.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unifacear.classes.Endereco;
import br.edu.unifacear.facade.EnderecoFacade;

@ManagedBean(name="enderecoBean")
@RequestScoped
public class EnderecoController {
	
	
	private Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public EnderecoController() {
		this.endereco = new Endereco();
	}
	
	public void salvar() throws Exception {
		try {
			EnderecoFacade facade = new EnderecoFacade();
			facade.salvar(this.endereco);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	
}
