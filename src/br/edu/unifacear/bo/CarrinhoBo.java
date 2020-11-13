package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.dao.CarrinhoDao;
import br.edu.unifacear.dao.GenericDao;

public class CarrinhoBo {

	public List<Carrinho> listar(String pesquisa, Carrinho parametro, int parametro2) throws Exception {
		
		try {
			return new CarrinhoDao().listar(pesquisa, parametro, parametro2);
		}catch(Exception e) {
			throw new Exception("Erro ao listar");
		}
		
	
	}
	
	public void Salvar(Carrinho carrinho) throws Exception {
		new GenericDao().saveOrUpdate(carrinho);
	}

}
