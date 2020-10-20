package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.TipoEntrega;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.dao.TipoEntregaDao;

public class TipoEntregaBo {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void salvarValidar(String pesquisa, TipoEntrega parametro) throws Exception {
		
		List<TipoEntrega> lista = new TipoEntregaDao().listar("todos", parametro);
		
		for (TipoEntrega tipoEntrega : lista) {
			if(tipoEntrega.getDescricao().toUpperCase().equals(parametro.getDescricao().toUpperCase())) {
				throw new Exception("Erro tipo de entrega ja cadastrado");
			}
		}
		new GenericDao().saveOrUpdate(parametro);
	}
	
}
