package br.edu.unifacear.bo;

import br.edu.unifacear.classes.Comissao;
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
	
}
