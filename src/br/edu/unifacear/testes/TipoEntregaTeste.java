package br.edu.unifacear.testes;

import br.edu.unifacear.bo.TipoEntregaBo;
import br.edu.unifacear.classes.TipoEntrega;
import br.edu.unifacear.controller.TipoEntregaController;

public class TipoEntregaTeste {

	public static void main(String[] args) {
		TipoEntrega t = new TipoEntrega();
		
		t.setDescricao("Sedex");
		
		TipoEntregaController c = new TipoEntregaController();
		c.setTipo(t);
		c.salvar();
		
	}

}
