package br.edu.unifacear.facade;



import java.util.List;

import br.edu.unifacear.bo.CalcadoBo;
import br.edu.unifacear.classes.Calcado;

public class CalcadoFacade {
	
	private CalcadoBo calcadoBo;
	
	
	public CalcadoFacade() {
		this.calcadoBo = new CalcadoBo();
	}
	
	
	public void salvar(Calcado calcado, String pesquisa, String parametro) throws Exception {
		this.calcadoBo = new CalcadoBo();
		this.calcadoBo.salvarValidar(pesquisa, calcado, parametro);
	}
	
	public List<Calcado> listar(Calcado calcado, String pesquisa, String parametro) throws Exception{
		this.calcadoBo = new CalcadoBo();
		return this.calcadoBo.listar(pesquisa, calcado, parametro);
	}
}
