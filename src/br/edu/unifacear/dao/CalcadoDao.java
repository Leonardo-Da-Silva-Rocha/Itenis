package br.edu.unifacear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Calcado;


public class CalcadoDao {
	
	
	@SuppressWarnings("unchecked")
	public List<Calcado> listar(String pesquisa, Calcado parametro){
		
		Query consulta = null;
		List<Calcado> calcado = null;
		
		EntityManager em = Fabrica.getEntityManager();
		
		em.getTransaction().begin();
		
		if(pesquisa.equals("todos")) {
			 consulta = em.createQuery("SELECT c FROM Calcado c");
			 
		}
		
		calcado = consulta.getResultList();
		em.getTransaction().commit();
		
		em.close();
		
		return calcado;
		
	}
	
}
