package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Fornecedor;
import br.edu.unifacear.facade.FornecedorFacade;


@ManagedBean(name="fornecedorBean")
@RequestScoped
public class FornecedorController {
	
	private Fornecedor fornecedor;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FornecedorController() {
		this.fornecedor = new Fornecedor();
	}
	
	
	public void salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			
			FornecedorFacade facade = new FornecedorFacade();
			facade.inserirFornecedor(fornecedor);
			
			
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
		}
		
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Categoria salva com sucesso",""));
		
	}
	
	
	
}
