package br.edu.unifacear.controller;

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

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public MarcaController() {
		this.marca = new Marca();
	}
	
	
	public void salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		try {
			//pessoaBo = new PessoaBo();
			//pessoaBo.salvar(this.pessoa);
			MarcaFacade facade = new MarcaFacade();
			facade.inserirMarca(this.marca);
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
				
		}
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Pessoa salva com sucesso!", ""));	
		
			
		
	}
	
}
