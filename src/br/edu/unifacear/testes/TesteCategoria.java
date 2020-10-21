package br.edu.unifacear.testes;

import br.edu.unifacear.bo.CategoriaBo;
import br.edu.unifacear.classes.Categoria;
import br.edu.unifacear.controller.CategoriaController;

public class TesteCategoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Categoria categoria = new Categoria();
		categoria.setDescricao("Adulto");
		
		
		CategoriaController c = new CategoriaController();
		c.setCategoria(categoria);
		c.salvar();

	}

}
