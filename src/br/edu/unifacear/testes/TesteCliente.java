package br.edu.unifacear.testes;

import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.controller.ClienteController;

public class TesteCliente {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		
		cliente.setEmail("antonio@gmail.com");
		cliente.setNome("Ant");
		cliente.setSenha("123");
		cliente.setCpf("333.999.333-88");
		
		
		ClienteController c = new ClienteController();
		c.setCliente(cliente);
		try {
			c.salvar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
