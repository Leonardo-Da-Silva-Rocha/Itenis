package br.edu.unifacear.bo;

import br.edu.unifacear.classes.Vendedor;
import br.edu.unifacear.dao.GenericDao;

public class VendedorBo {

	
	public void salvar(Vendedor vendedor)throws Exception {
		
		
		try {
			new GenericDao().saveOrUpdate(vendedor);
		}catch(Exception e) {
			throw new Exception("Erro ao salvar vendedor");
		}
		
		
	}
	
	
}
