package br.edu.unifacear.facade;

import br.edu.unifacear.bo.AdministradorBo;
import br.edu.unifacear.classes.Administrador;

public class AdministradorFacade {
	
	private AdministradorBo admBo;
	
	
	public AdministradorFacade() {
		this.admBo = new AdministradorBo();
	}
	
	
	public void inserirAdministrador(Administrador adm) throws Exception {
		this.admBo = new AdministradorBo();
		this.admBo.salvarValidar(adm, "todos");
	}
	
	
}
