package br.edu.unifacear.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Marca;

public class MarcaDao {
	
	@SuppressWarnings("unchecked")
	public List<Marca> listar(String pesquisa, Marca marca){
		
		EntityManager em = Fabrica.getEntityManager();
		
		List<Marca> lista = null;
		
		Query consulta = null;
		
		em.getTransaction().begin();
		
		if(pesquisa.equals("todos")) {
			consulta = em.createQuery("SELECT m FROM Marca m");
		}
		
		em.getTransaction().commit();
		
		lista = consulta.getResultList();
		
		return lista;
		
	}
	

	
	
	
	
	
	

}
