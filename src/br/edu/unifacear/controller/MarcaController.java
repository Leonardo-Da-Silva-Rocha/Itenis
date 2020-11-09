package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Marca;
import br.edu.unifacear.facade.MarcaFacade;


@ManagedBean(name="marcaBean")
@RequestScoped
public class MarcaController {
	
	private Marca marca;
	private List<String> marcas;

	

	public List<String> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<String> marcas) {
		this.marcas = marcas;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
		
	}

	public MarcaController() {
		this.marca = new Marca();
		this.marcas = new ArrayList<>();
		carregarComboBox();
	}
	
	
	public void salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		try {
			//pessoaBo = new PessoaBo();
			//pessoaBo.salvar(this.pessoa);
			MarcaFacade facade = new MarcaFacade();
			facade.inserirMarca(this.marca);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Marca salva com sucesso!", ""));
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
				
		}
		
			
		
	
	}
	
	
	
	public void alterar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		try {
			//pessoaBo = new PessoaBo();
			//pessoaBo.salvar(this.pessoa);
			MarcaFacade facade = new MarcaFacade();
			facade.alterar(marca);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Marca salva com sucesso!", ""));
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
				
		}
		
			
		
	
	}
	
	
	public void carregarComboBox(){
		
		MarcaFacade facade = new MarcaFacade();
		
		 for (Marca marca : facade.listar("todos", new Marca())) {
			this.marcas.add(marca.getDescricao());
		}
		 
		
		
	}
	
}
