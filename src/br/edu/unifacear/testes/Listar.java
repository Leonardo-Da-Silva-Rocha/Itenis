package br.edu.unifacear.testes;

import java.util.List;

import br.edu.unifacear.classes.Vendedor;
import br.edu.unifacear.dao.VendedorDao;

public class Listar {

	public static void main(String[] args) {
		List<Vendedor> lista = new VendedorDao().listar("");
		System.out.println(lista.get(0).getNome());
	}

}
