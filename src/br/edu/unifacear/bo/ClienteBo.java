package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.dao.ClienteDao;
import br.edu.unifacear.dao.GenericDao;


public class ClienteBo {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void salvarValidar(Cliente cliente) throws Exception {
		
		List<Cliente> lista = new ClienteDao().listar("todos", cliente);
		
		for (Cliente cliente2 : lista) {
			
			if(cliente2.getEmail().toUpperCase().equals(cliente.getEmail().toUpperCase())) {
				throw new Exception("Erro ao salvar, email ja cadastrado");
			}
			
		}
		
		new GenericDao().saveOrUpdate(cliente);
	}
	
	
	public List<Cliente>  listar(String pesquisa, Cliente cli) throws Exception{
		
		try {
			return new ClienteDao().listar(pesquisa, cli);
		}catch(Exception e) {
			throw new Exception("Erro ao listar");
		}
		
	}
	
}
