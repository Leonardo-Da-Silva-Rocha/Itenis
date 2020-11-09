package br.edu.unifacear.facade;

import java.util.List;

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
	
	public void alterar(Categoria categoria) throws Exception {
		this.categoriaBo = new CategoriaBo();
		categoriaBo.alterar(categoria);
	}
	
	public List<Categoria> listar(String pesquisa, String parametro){
		this.categoriaBo = new CategoriaBo();
		return this.categoriaBo.listar(pesquisa, parametro);
	}
	
}
