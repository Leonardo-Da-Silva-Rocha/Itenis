package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Marca;
import br.edu.unifacear.dao.MarcaDao;

public class MarcaBo {
	

	public void validarMarcaSalvar(Marca marca) throws Exception {
		
		for (Marca lista : listar("todos", new Marca())) {
			if(lista.getDescricao().equals(marca.getDescricao())) {
				throw new Exception("Erro marca já cadastrada");
			}
		}
		try {
			new MarcaDao().salvar(marca);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public void alterar(Marca marca) throws Exception {
		
		try {
			new MarcaDao().alterar(marca);
		}catch(Exception e) {
			throw new Exception("Erro ao salvar marca");
		}
		
	}
	public List<Marca> listar(String pesquisa, Marca marca) {
		
		
		return new MarcaDao().listar(pesquisa, marca);
		
	}
	
}
