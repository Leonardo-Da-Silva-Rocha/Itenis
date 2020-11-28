package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Administrador;
import br.edu.unifacear.dao.AdministradorDao;
import br.edu.unifacear.dao.GenericDao;

public class AdministradorBo {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void salvarValidar(Administrador adm, String pesquisa) throws Exception{
		
		List<Administrador> lista = new AdministradorDao().listar(adm, pesquisa);
		
		for (Administrador administrador : lista) {
			if(administrador.getNome().toUpperCase().equals(adm.getNome().toUpperCase())) {
				throw new Exception("Erro ao salvar, administrador ja existente");
			}
		}
		
		
		new GenericDao().saveOrUpdate(adm);
		
	}
	
	public List<Administrador> listar(Administrador adm, String pesquisa) throws Exception{
		try {
			return new AdministradorDao().listar(adm, pesquisa);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
