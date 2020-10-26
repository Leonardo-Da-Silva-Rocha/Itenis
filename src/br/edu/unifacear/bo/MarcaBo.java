package br.edu.unifacear.bo;

import java.util.List;

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
	
	
	public List<Marca> listar(String pesquisa, Marca marca) {
		
		
		return new MarcaDao().listar(pesquisa, marca);
		
	}
	
}
