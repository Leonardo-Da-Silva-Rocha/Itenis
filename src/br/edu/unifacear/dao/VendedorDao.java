package br.edu.unifacear.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Vendedor;

public class VendedorDao {
	
	
	public List<Vendedor> listar(String pesquisa){
		
		EntityManager em = Fabrica.getEntityManager();
		
		List<Vendedor> lista = null;
		
		Query consulta = null;
		
		em.getTransaction().begin();
		
		if(pesquisa.equals("todos")) {
			consulta = em.createQuery("SELECT v FROM Vendedor v");
		}
		
		em.getTransaction().commit();
		
		lista = consulta.getResultList();
		
		return lista;
		
	}
	
	
	
	
}
