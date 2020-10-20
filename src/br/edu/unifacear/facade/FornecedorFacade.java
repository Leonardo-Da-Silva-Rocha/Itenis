package br.edu.unifacear.facade;

import br.edu.unifacear.bo.FornecedorBo;
import br.edu.unifacear.classes.Fornecedor;

public class FornecedorFacade {
	
	private FornecedorBo fornecedorBo;
	
	
	public FornecedorFacade() {
		this.fornecedorBo = new FornecedorBo();
	}
	
	public void inserirFornecedor(Fornecedor fornecedor) throws Exception {
		
		this.fornecedorBo = new FornecedorBo();
		this.fornecedorBo.salvarValidar("todos", fornecedor);
	}
	
	
	
}
