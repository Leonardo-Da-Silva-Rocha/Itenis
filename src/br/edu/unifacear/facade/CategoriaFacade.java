package br.edu.unifacear.facade;

import br.edu.unifacear.bo.CategoriaBo;
import br.edu.unifacear.classes.Categoria;


public class CategoriaFacade {
	
	
	private CategoriaBo categoriaBo;
	
	
	public CategoriaFacade() {
		this.categoriaBo = new CategoriaBo();
	}
	
	public void inserirCategoria(Categoria categoria) throws Exception {
		this.categoriaBo = new CategoriaBo();
		categoriaBo.salvar(categoria);
	}
	
}
