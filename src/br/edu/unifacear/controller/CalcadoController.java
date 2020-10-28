package br.edu.unifacear.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Marca;
import br.edu.unifacear.facade.CadastrarCalcadoFacade;
import br.edu.unifacear.facade.CalcadoFacade;

@ManagedBean(name="calcadoBean")
@RequestScoped
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
	
		public void salvar() throws Exception {
		
				FacesContext context = FacesContext.getCurrentInstance();
			
			
				try {
					
					CadastrarCalcadoFacade facade = new CadastrarCalcadoFacade();
					
					
					this.calcado.setMarca(facade.listarMarca(this.calcado.getMarca()).get(0));    
					this.calcado.setCategoria(facade.listarCategoria(this.calcado.getCategoria().getDescricao()).get(0));
					this.calcado.setFornecedor(facade.listarFornecedor(this.calcado.getFornecedor()).get(0));
					facade.salvar(calcado);
					
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Calçado cadastrado com sucesso",""));
					
					
				}catch(Exception e) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							e.getMessage(),""));
				}
				
				
				
				
		
	}
	
	public List<Calcado> listar(Calcado calcado, String pesquisa, String parametro) throws Exception{
		CalcadoFacade facade = new CalcadoFacade();
		return facade.listar(calcado, pesquisa, parametro);
	}
	
	public void adicionarMarca() {
		this.calcado.setMarca(new CadastrarCalcadoFacade().listarMarca(this.calcado.getMarca()).get(0));
	}
	
}
