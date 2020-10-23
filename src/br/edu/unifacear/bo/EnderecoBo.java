package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Endereco;
import br.edu.unifacear.dao.EnderecoDao;
import br.edu.unifacear.dao.GenericDao;

public class EnderecoBo {
	
	public void salvar(Endereco endereco) throws Exception {
		
		if(endereco.getNumero() != -0) {
			new GenericDao().saveOrUpdate(endereco);
			endereco = new Endereco();
		}
		else {
			endereco = new Endereco();
		}
		
		
	}
	
}
