package br.edu.unifacear.testes;

import br.edu.unifacear.classes.Fornecedor;
import br.edu.unifacear.controller.FornecedorController;

public class TesteFornecedor {
	
	
	
	public static void main(String[] args) {
		
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setDescricao("Adidas Brasil Sa");
		fornecedor.setEndereco("Monte Rural 52, São Paulo");
		fornecedor.setTelefone("11 5959-7878");
		fornecedor.setCodigo("155");
		
		FornecedorController c = new FornecedorController();
		c.setFornecedor(fornecedor);
		c.salvar();
	}
	
	
	
	
}
