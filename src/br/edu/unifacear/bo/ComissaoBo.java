package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Comissao;
import br.edu.unifacear.dao.ComissaoDao;
import br.edu.unifacear.dao.GenericDao;

public class ComissaoBo {
	
	public void Salvar(Comissao comissao)  {
		try {
			new GenericDao().saveOrUpdate(comissao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Comissao> listar(int parametro) throws Exception {
		try {
			return new ComissaoDao().listar(parametro);
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
	}
	
}
