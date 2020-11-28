package br.edu.unifacear.facade;



import java.util.List;

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
	
	public List<Administrador> listar(Administrador adm, String pesquisa) throws Exception {
		this.admBo = new AdministradorBo();
		return this.admBo.listar(adm, pesquisa);
	}
	
}
