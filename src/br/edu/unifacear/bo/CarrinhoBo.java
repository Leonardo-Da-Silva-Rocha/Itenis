package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.dao.CarrinhoDao;

public class CarrinhoBo {

	public List<Carrinho> listar(String pesquisa, Carrinho parametro) throws Exception {
		
		try {
			return new CarrinhoDao().listar(pesquisa, parametro);
		}catch(Exception e) {
			throw new Exception("Erro ao listar");
		}
		
	
	}

}
