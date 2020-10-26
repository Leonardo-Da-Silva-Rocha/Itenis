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
		carregarCombo();
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
	
	public void carregarCombo() {
		
		for (Categoria categoria : new CategoriaFacade().listar("todos", "")) {
			this.categorias.add(categoria.getDescricao());
		}
		
	}
	
}
