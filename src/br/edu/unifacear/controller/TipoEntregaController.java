package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.TipoEntrega;
import br.edu.unifacear.dao.TipoEntregaDao;
import br.edu.unifacear.facade.TipoEntregaFacade;

@ManagedBean(name = "tipoEntregaBean")
@RequestScoped
public class TipoEntregaController {

	private TipoEntrega tipo;

	private List<String> entregas;

	private List<TipoEntrega> tipos;

	public List<TipoEntrega> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoEntrega> tipos) {
		this.tipos = tipos;
	}

	public List<String> getEntregas() {
		return entregas;
	}

	public void setEntregas(List<String> entregas) {
		this.entregas = entregas;
	}

	public TipoEntregaController() {
		this.tipos = new ArrayList<>();
		this.tipo = new TipoEntrega();
		this.entregas = new ArrayList<>();
		carregar();
		
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
			carregar();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo de entrega salvo", ""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

		
	}

	public void alterar() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			TipoEntregaFacade facade = new TipoEntregaFacade();
			facade.alterar(tipo);
			carregar();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Entrega Alterada", ""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), ""));
		}

		
	}

	public void remover() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			TipoEntregaFacade facade = new TipoEntregaFacade();
			facade.remover(tipo);
			carregar();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo de entrega removida", ""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

		
	}

	public void carregar() {
		this.entregas = new ArrayList<>();
		for (TipoEntrega lista : new TipoEntregaDao().listar("todos", new TipoEntrega())) {
			this.entregas.add("ID = " + lista.getId() + " Descrição: " + lista.getDescricao());
			this.tipos.add(lista);
		}
		
	}

	

}