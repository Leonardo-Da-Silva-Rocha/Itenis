package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Vendedor;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.dao.VendedorDao;

public class VendedorBo {

	
	public void salvar(Vendedor vendedor)throws Exception {
		
		validar(vendedor);
		
		try {
			new GenericDao().saveOrUpdate(vendedor);
		}catch(Exception e) {
			throw new Exception("Erro ao salvar vendedor");
		}
		
		
	}
	
	public void validar(Vendedor vendedor) throws Exception {
		
		List<Vendedor> lista = new VendedorDao().listar("todos");
		
		for (Vendedor vendedor2 : lista) {
			
			if(vendedor2.getEmail().toUpperCase().equals(vendedor.getEmail().toUpperCase())) {
				throw new Exception("Erro, Email já cadastrado");
			}
			
			
		}
		
		if(vendedor.getConfirmarSenha().equals(vendedor.getSenha()) == false) {
			throw new Exception("Erro, as senhas não são iguais");
		}
		
	}
	
	public List<Vendedor> listar(String pesquisa) throws Exception {
		
		try {
			
			return new VendedorDao().listar(pesquisa);
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
}
