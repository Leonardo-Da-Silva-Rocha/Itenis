package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Administrador;
import br.edu.unifacear.facade.AdministradorFacade;

public class AdministradorController {
	
	private Administrador adm;

	public Administrador getAdm() {
		return adm;
	}

	public void setAdm(Administrador adm) {
		this.adm = adm;
	}

	public AdministradorController() {
		this.adm = new Administrador();
	}
	
	
	public void salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			
			AdministradorFacade facade = new AdministradorFacade();
			facade.inserirAdministrador(adm);
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
		}
		
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Erro ao salvar o administrador",""));
		
	}
	
	
}
