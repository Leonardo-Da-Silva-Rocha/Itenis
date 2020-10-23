package br.edu.unifacear.bo;

import br.edu.unifacear.classes.Marca;
import br.edu.unifacear.dao.MarcaDao;

public class MarcaBo {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void validarMarcaSalvar(Marca marca) throws Exception {
		
		
		try {
			new MarcaDao().salvar(marca);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}
	
}
