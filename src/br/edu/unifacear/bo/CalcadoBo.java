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
				
				if(calcado2.getNumero() == calcado.getNumero()) {//valida o tamanho do calçado
					
					throw new Exception("Não foi possível cadastrar, tamanho ja cadastrado");
					
				}
				
				if(calcado2.getPartNumber() == calcado.getPartNumber() ) {
					throw new Exception("Não foi possível cadastrar, PartNumber já cadastrado");
				}
				else if(calcado.getPartNumber() <= 0) {
					throw new Exception("Não foi possível cadastrar, PartNumber invalido");
				}
				
			}
		}
		
		
		
		if(calcado.getCodigoFornecedor().equals(calcado.getFornecedor().getCodigo()) == false) { //valida o codigo da empresa
			throw new Exception("Não foi possível cadastrar, Codigo da empresa fornecedora invalido");
		}
		else if(calcado.getNumero() < 32 || calcado.getNumero() > 42) {//valida o numero do caçado
			throw new Exception("Não foi possível cadastrar, Numero do calçado invalido");
		}
		else if(calcado.getQuantidade() <= 0) {// valida a quantidade daquele calçado
			throw new Exception("Não foi possível cadastrar, quantidade de calçado invalida");
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
