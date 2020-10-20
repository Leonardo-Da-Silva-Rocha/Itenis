package br.edu.unifacear.facade;

import br.edu.unifacear.bo.TipoEntregaBo;
import br.edu.unifacear.classes.TipoEntrega;

public class TipoEntregaFacade {
	
	
	private TipoEntregaBo tipoBo;
	
	public TipoEntregaFacade() {
		this.tipoBo = new TipoEntregaBo();
	}
	
	public void inserirTipoEntrega(TipoEntrega tipo) throws Exception {
		this.tipoBo = new TipoEntregaBo();
		this.tipoBo.salvarValidar("todos", tipo);
	}
	
}
