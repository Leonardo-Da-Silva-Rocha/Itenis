package br.edu.unifacear.facade;

import br.edu.unifacear.bo.ComissaoBo;
import br.edu.unifacear.classes.Comissao;

public class ComissaoFacade {

	private ComissaoBo comissaoBo;

	public ComissaoBo getComissaoBo() {
		return comissaoBo;
	}

	public void setComissaoBo(ComissaoBo comissaoBo) {
		this.comissaoBo = comissaoBo;
	}

	public ComissaoFacade() {
		this.comissaoBo = new ComissaoBo();
	}
	
	public void salvar(Comissao comissao) {
		this.comissaoBo = new ComissaoBo();
		this.comissaoBo.Salvar(comissao);
	}

}
