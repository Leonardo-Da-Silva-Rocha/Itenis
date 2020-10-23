package br.edu.unifacear.facade;

import br.edu.unifacear.bo.MarcaBo;
import br.edu.unifacear.classes.Marca;

public class MarcaFacade {
	
	private MarcaBo marcaBo;
	
	public MarcaFacade() {
		this.marcaBo = new MarcaBo();
	}
	
	public void inserirMarca(Marca marca) throws Exception {
		this.marcaBo = new MarcaBo();
		this.marcaBo.validarMarcaSalvar(marca);
	}
	
	
	
}