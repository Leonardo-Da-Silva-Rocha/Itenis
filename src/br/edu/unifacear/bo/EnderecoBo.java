package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Endereco;
import br.edu.unifacear.dao.EnderecoDao;
import br.edu.unifacear.dao.GenericDao;

public class EnderecoBo {
	
	public void salvar(Endereco endereco) throws Exception {
		System.out.println("oi");
		if(endereco.getNumero() != 0) {
			System.out.println("save");
			new GenericDao().saveOrUpdate(endereco);
			endereco = new Endereco();
		}
		else {
			System.out.println("erro");
			endereco = new Endereco();
		}
		
		
	}
	
}
