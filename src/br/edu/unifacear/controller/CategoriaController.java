package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Categoria;
import br.edu.unifacear.facade.CategoriaFacade;

@ManagedBean(name="categoriaBean")
@RequestScoped
public class CategoriaController {
	
	private Categoria categoria;

	private List<String> categorias;
	private List<String> listaCategorias;
	
	
	
	
	public List<String> getListaCategorias() {
		return listaCategorias;
	}



	public void setListaCategorias(List<String> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}



	public List<String> getCategorias() {
		return categorias;
	}



	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}



	public Categoria getCategoria() {
		return categoria;
	}

	
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	} 
	 

	public CategoriaController() {
		this.categoria = new Categoria();
		this.categorias = new ArrayList<>();
		this.listaCategorias = new ArrayList<>();
		carregarCombo();
		carregarCategorias();
	}
	
	
	

	public void salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			
			CategoriaFacade facade = new CategoriaFacade();
			facade.inserirCategoria(categoria);
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
		}
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Categoria salva com sucesso",""));
	}
	
	public void alterar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			
			CategoriaFacade facade = new CategoriaFacade();
			facade.alterar(categoria);
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
		}
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Categoria salva com sucesso",""));
	}
	
	public void remover() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			
			CategoriaFacade facade = new CategoriaFacade();
			facade.remover(categoria);
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
		}
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Categoria removida com sucesso",""));
	}
	
	
	public void carregarCombo() {
		
		for (Categoria categoria : new CategoriaFacade().listar("todos", "")) {
			this.categorias.add("ID = "+categoria.getIdCategoria() +" Desrição: " + categoria.getDescricao());
		}
		
	}
	
	public void carregarCategorias() {
		
		for (Categoria categoria : new CategoriaFacade().listar("todos", "")) {
			this.listaCategorias.add(categoria.getDescricao());
		}
		
	}
	
}
