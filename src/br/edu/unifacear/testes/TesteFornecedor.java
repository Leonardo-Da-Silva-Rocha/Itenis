package br.edu.unifacear.testes;

import br.edu.unifacear.classes.Fornecedor;
import br.edu.unifacear.controller.FornecedorController;

public class TesteFornecedor {
	
	
	
	public static void main(String[] args) {
		
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setDescricao("ola");
		fornecedor.setEndereco("sagu 32, São Paulo");
		fornecedor.setTelefone("11 3434-7878");
		fornecedor.setCodigo("123");
		
		FornecedorController c = new FornecedorController();
		c.setFornecedor(fornecedor);
		c.salvar();
	}
	
	
	
	
}
