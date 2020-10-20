package br.edu.unifacear.testes;

import br.edu.unifacear.classes.Marca;
import br.edu.unifacear.dao.GenericDao;

public class Teste {

	public static void main(String[] args) {
		
		Marca grp = new Marca();
			
		grp.setDescricao("Adidas");
		grp.setIdMarca(8);
	
		try {
			new GenericDao().saveOrUpdate(grp);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
