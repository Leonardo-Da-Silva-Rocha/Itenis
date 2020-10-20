package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.TipoEntrega;
import br.edu.unifacear.facade.TipoEntregaFacade;

public class TipoEntregaController {
	
	
	private TipoEntrega tipo;
	
	
	public TipoEntregaController() {
		this.tipo = new TipoEntrega();
	}


	public TipoEntrega getTipo() {
		return tipo;
	}


	public void setTipo(TipoEntrega tipo) {
		this.tipo = tipo;
	}
	
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			TipoEntregaFacade facade = new TipoEntregaFacade();
			facade.inserirTipoEntrega(tipo);
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
		}
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Tipo Salvo",""));
	}
	
}
