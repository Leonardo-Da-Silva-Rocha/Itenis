package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Vendedor;
import br.edu.unifacear.facade.VendedorFacade;


@ManagedBean(name="vendedorBean")
@RequestScoped
public class VendedorController {
	
	private Vendedor vendedor;
	
	
	public Vendedor getVendedor() {
		return vendedor;
	}




	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


	public VendedorController() {
		this.vendedor = new Vendedor();
		
	}
	
	
	
	public void salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			
			VendedorFacade facade = new VendedorFacade();
			facade.inserirVendedor(vendedor);
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
		}
		
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Vendedor Salvo com sucesso",""));
		
	}

	
}
