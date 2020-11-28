package br.edu.unifacear.testes;

import br.edu.unifacear.classes.Marca;
import br.edu.unifacear.controller.MarcaController;

public class TesteMarca {

	public static void main(String[] args) {

		Marca marca = new Marca();
		marca.setDescricao("Mizuno");
		MarcaController controller = new MarcaController();
		controller.setMarca(marca);

		controller.salvar();

	}

}