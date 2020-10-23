package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.facade.CarrinhoFacade;

public class CarrinhoController {
	
	private Carrinho carrinho;

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public CarrinhoController() {
		this.carrinho = new Carrinho();
	}
	
	public String salvar(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			CarrinhoFacade facade = new CarrinhoFacade();
			facade.criarCarrinho(this.carrinho);
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
		}
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Carrinho criado",""));
		return "Carrinho criado";
		
	}
	
	
	
	
}
