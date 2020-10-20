package br.edu.unifacear.testes;

import br.edu.unifacear.classes.Administrador;
import br.edu.unifacear.classes.Vendedor;
import br.edu.unifacear.controller.VendedorController;
import br.edu.unifacear.dao.GenericDao;

public class TesteVendedor {

	public static void main(String[] args) {
		Vendedor ven = new Vendedor();
		Administrador adm = new Administrador();
		adm.setIdAdministrador(1);
		ven.setAdministrador(adm);
		ven.setCnpj("43.777.657/0001-60");
		ven.setEmail("loja@gmail.com");
		ven.setEnderecoLoja("rua rodolpho, 23");
		ven.setSenha("123");
		ven.setTelefone("41 3445-3221");
		ven.setNome("Cleiton");
		ven.setNomeLoja("Lojas araucaria");
		VendedorController c = new VendedorController();
		c.setVendedor(ven);
		c.salvar();
		
	}

}
