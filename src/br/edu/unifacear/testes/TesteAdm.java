package br.edu.unifacear.testes;



import br.edu.unifacear.classes.Administrador;
import br.edu.unifacear.controller.AdministradorController;

public class TesteAdm {

	public static void main(String[] args) {
		
		Administrador adm = new Administrador();
		
		adm.setNome("Junior");
		adm.setSenha("321");
		
		
		AdministradorController c = new AdministradorController();
		c.setAdm(adm);
		c.salvar();

	}

}
