package br.edu.unifacear.testes;

import br.edu.unifacear.classes.Marca;
import br.edu.unifacear.controller.MarcaController;

public class AlterarMarca {

	public static void main(String[] args) {
		Marca m = new Marca();
		m.setIdMarca(1);
		m.setDescricao("teste");
		
		MarcaController c = new MarcaController();
		c.setMarca(m);
		c.alterar();

	}

}
