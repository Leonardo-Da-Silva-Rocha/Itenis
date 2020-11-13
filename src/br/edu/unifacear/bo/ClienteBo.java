package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.dao.ClienteDao;


public class ClienteBo {
	
	
	public void salvarValidar(Cliente cliente) throws Exception {
		
		
		
		new ClienteDao().salvar(cliente);
	}
	
	
	public List<Cliente>  listar(String pesquisa, Cliente cli) throws Exception{
		
		try {
			return new ClienteDao().listar(pesquisa, cli);
		}catch(Exception e) {
			throw new Exception("Erro ao listar");
		}
		
	}
	

	
	public void validar(Cliente cliente) throws Exception {
		
		List<Cliente> lista = new ClienteDao().listar("todos", cliente);
		
		for (Cliente cliente2 : lista) { //valida email
			
			if(cliente.getEmail().toUpperCase().equals(cliente2.getEmail().toUpperCase())) {
				cliente = new Cliente();
				cliente.getEndereco().setNumero(-0);
				
				throw new Exception("E-mail ja cadastrado, informe outro e-mail");
			}
		}
		
		if(cliente.getSenha().toLowerCase().equals(cliente.getConfirmarSenha().toUpperCase()) == false) {
			cliente = new Cliente();
			throw new Exception("As senhas não são iguais");
		}
		
	}
	
	
	public void logar(Cliente cliente) throws Exception {
		
		boolean validar = false;
		
		List<Cliente> lista = new ClienteDao().listar("todos", cliente);
		
		for (Cliente cliente2 : lista) {
			
			if(cliente.getEmail().toUpperCase().equals(cliente2.getEmail().toUpperCase())) {
				
				validar = true;
				
				if(cliente.getSenha().equals(cliente2.getSenha()) == false) {
					
					validar = false;
					
				}
				
				cliente.setCpf(cliente2.getCpf());
				cliente.setNome(cliente2.getNome());
				cliente.setIdCliente(cliente2.getIdCliente());
				
			}
			
		}
		
		if(validar == false) {
		
			throw new Exception("E-mail ou senha invalido");
		}
		
		
		
	}
	
}
