package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.dao.CalcadoDao;
import br.edu.unifacear.dao.GenericDao;

public class CalcadoBo {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void salvarValidar(String pesquisa, Calcado calcado, String parametro2) throws Exception {
		
		List<Calcado> lista = new CalcadoDao().listar(pesquisa, calcado, parametro2);
		
		for (Calcado calcado2 : lista) {
			
			if(calcado2.getDescricao().toUpperCase().equals(calcado.getDescricao().toUpperCase())) {
				
				if(calcado2.getNumero() == calcado.getNumero()) {
					
					throw new Exception("Nao foi possivel cadastrar, tamanho ja cadastrado");
					
				}
				
			}
		}
		
		new GenericDao().saveOrUpdate(calcado);
		
	}
	
	public List<Calcado> listar(String pesquisa, Calcado parametro, String parametro2) throws Exception{
		try {
			return new CalcadoDao().listar(pesquisa, parametro, parametro2);
		}catch(Exception e) {
			throw new Exception("Erro ao listar o calcado");
		}
	}
	
}
