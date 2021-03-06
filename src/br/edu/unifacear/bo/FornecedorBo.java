package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Fornecedor;
import br.edu.unifacear.classes.Fornecedor;
import br.edu.unifacear.dao.FornecedorDao;
import br.edu.unifacear.dao.GenericDao;

public class FornecedorBo {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void salvarValidar(String pesquisa, Fornecedor fornecedor) throws Exception {
		
		List<Fornecedor> lista = new FornecedorDao().listar(pesquisa, fornecedor);
			
		for (Fornecedor fornecedor2 : lista) {
			if(fornecedor2.getDescricao().toUpperCase().equals(fornecedor.getDescricao().toUpperCase())) {
				throw new Exception("Erro, fornecedor ja cadastrado");
			}
		}
		
		new GenericDao().saveOrUpdate(fornecedor);
		
	}
	
	
	public List<Fornecedor> listar(String pesquisa, Fornecedor fornecedor){
		return new FornecedorDao().listar(pesquisa, fornecedor);
	}
	
	
	public void remover(Fornecedor fornecedor) throws Exception {
		
		try {
			new GenericDao().remove(fornecedor.getClass(), fornecedor.getId());
		}catch(Exception e) {
			throw new Exception("Erro ao remover");
		}
		
	}
	
	public void alterar(Fornecedor fornecedor) throws Exception {
		
		try {
			new FornecedorDao().alterar(fornecedor);
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
}
