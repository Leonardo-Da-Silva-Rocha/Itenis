package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.facade.CadastrarClienteFacade;
import br.edu.unifacear.facade.ClienteFacade;


@ManagedBean(name="clienteBean")
@RequestScoped
public class ClienteController {
	
	
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
		
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ClienteController() {
		this.cliente = new Cliente();
	
	}
	
	
	public void salvar() throws Exception {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		
		try {
			
			CadastrarClienteFacade facade = new CadastrarClienteFacade();
			facade.salvar(this.cliente.getEndereco(), this.cliente);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Cadastrado com sucesso no site",""));
			
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao salvar ","verifique se o email ja esta em uso em nosso site e se as senhas são iguais"));
		}
		
		
		
	}
	
	public void logar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			ClienteFacade facade = new ClienteFacade();
			facade.login(cliente);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Bem vindo" ,""));
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
		}
		
	}

	
}
