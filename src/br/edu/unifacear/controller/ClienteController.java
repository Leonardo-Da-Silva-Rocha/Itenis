package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Cliente;
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
	
	
	public void salvar() {
		
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			ClienteFacade facade = new ClienteFacade();
			facade.inserirCliente(this.cliente);
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
		}
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Cliente Salvo com sucesso",""));
		
	}
	
	
}
