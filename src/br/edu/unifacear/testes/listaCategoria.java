package br.edu.unifacear.testes;

import java.util.List;

import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.controller.CalcadoController;

public class listaCategoria {

	public static void main(String[] args) throws Exception {
		
		List<Calcado> lista = new CalcadoController().listar(new Calcado(), "marca", "Nike");
		
		for (Calcado categoria : lista) {
			System.out.println(categoria.getMarca().getDescricao());
		}

	}

}
