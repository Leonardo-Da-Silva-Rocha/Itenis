package br.edu.unifacear.testes;

import br.edu.unifacear.classes.Fornecedor;
import br.edu.unifacear.controller.FornecedorController;

public class AlterarFornecedor {

	public static void main(String[] args) {
		Fornecedor fo = new Fornecedor();
		fo.setIdFornecedor(2);
		fo.setDescricao("alterou");
		fo.setCodigo("5554");
		fo.setEndereco("rua teste, 54321");
		fo.setTelefone("41414141");
		
		FornecedorController gg = new FornecedorController();
		gg.setFornecedor(fo);
		gg.alterar();
	}

}
