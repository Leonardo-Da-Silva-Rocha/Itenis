package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

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
	private List<String> fornecedores;
	private String menssagem;
	
	
	

	public String getMenssagem() {
		return menssagem;
	}

	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}

	public List<String> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<String> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FornecedorController() {
		this.fornecedor = new Fornecedor();
		this.fornecedores = new ArrayList<>();
		carregarCombo();
	}
	
	
	public void salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			
			FornecedorFacade facade = new FornecedorFacade();
			facade.inserirFornecedor(fornecedor);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Fornecedor salvo com sucesso",""));
			
			this.menssagem = "Fornecedor salvo com sucesso";
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
			this.menssagem = e.getMessage();
		}
		
		

		
	}
	
	public void alterar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
			try {
				
				
				FornecedorFacade facade = new FornecedorFacade();
				facade.alterar(fornecedor);
				
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Fornecedor Alterado com sucesso",""));
				
				this.menssagem = "Fornecedor Alterado com sucesso";
				
			}catch(Exception e) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						e.getMessage(),""));
				this.menssagem = e.getMessage();
			}
		
		

		
	}
	
	public void carregarCombo() {
		
		for (Fornecedor fornecedor : new FornecedorFacade().listar("todos", this.fornecedor)) {
			this.fornecedores.add(fornecedor.getDescricao());
			
		}
		
	}
	
	
	
}
