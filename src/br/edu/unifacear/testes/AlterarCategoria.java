package br.edu.unifacear.testes;

import br.edu.unifacear.classes.Categoria;
import br.edu.unifacear.controller.CategoriaController;

public class AlterarCategoria {

	public static void main(String[] args) {
		Categoria c = new Categoria();
		c.setIdCategoria(1);
		c.setDescricao("teste");
		
		CategoriaController ct = new CategoriaController();
		ct.setCategoria(c);
		ct.alterar();

	}

}
