package br.edu.unifacear.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.facade.CalcadoFacade;

public class CalcadoController {
	
	private Calcado calcado;
	
	public CalcadoController() {
		this.calcado = new Calcado();
	}

	public Calcado getCalcado() {
		return calcado;
	}

	public void setCalcado(Calcado calcado) {
		this.calcado = calcado;
	}
	
	public void salvar(Calcado calcado, String pesquisa, String parametro) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			CalcadoFacade facade = new CalcadoFacade();
			facade.salvar(calcado, pesquisa, parametro);
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					e.getMessage(), ""));	
		}
		
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Calçado salvo com sucesso", ""));	
	}
	
	public List<Calcado> listar(Calcado calcado, String pesquisa, String parametro) throws Exception{
		CalcadoFacade facade = new CalcadoFacade();
		return facade.listar(calcado, pesquisa, parametro);
	}
	
}
