package br.edu.unifacear.facade;

import java.util.List;

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
	
	
	public List<Fornecedor> listar(String pesquisa, Fornecedor fornecedor){
		this.fornecedorBo = new FornecedorBo();
		return this.fornecedorBo.listar(pesquisa, new Fornecedor());
	}
	
}
