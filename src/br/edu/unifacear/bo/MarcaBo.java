package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Marca;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.dao.MarcaDao;

public class MarcaBo {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void validarMarcaSalvar(Marca marca) throws Exception {
		
		List<Marca> lista = new MarcaDao().listar("todos", marca);
		
		for (Marca parametro : lista) {
			if(parametro.getDescricao().toUpperCase().equals(marca.getDescricao().toUpperCase())) {
				throw new Exception("Erro ao salvar, marca ja existente");
			}
		}
		
		new GenericDao().saveOrUpdate(marca);
		
	}
	
}
