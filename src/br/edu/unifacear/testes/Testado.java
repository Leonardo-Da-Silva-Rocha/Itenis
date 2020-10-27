package br.edu.unifacear.testes;

import br.edu.unifacear.classes.Marca;
import br.edu.unifacear.controller.CalcadoController;
import br.edu.unifacear.facade.CadastrarCalcadoFacade;

public class Testado {
	
	public static void main(String[] args) {
		
		
		CalcadoController co = new CalcadoController();
		
		co.getCalcado().getMarca().setDescricao("adidas");
		co.getCalcado().getCategoria().setDescricao("infantil");
		co.getCalcado().getFornecedor().setDescricao("ola");
		try {
			co.salvar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
