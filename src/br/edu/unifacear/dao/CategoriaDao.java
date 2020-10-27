package br.edu.unifacear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Categoria;

public class CategoriaDao {

	@SuppressWarnings("unchecked")
	public List<Categoria> listar(String pesquisa, String parametro){
		
		Query consulta = null;
		List<Categoria> categoria = null;
		
		EntityManager em = Fabrica.getEntityManager();
		
		em.getTransaction().begin();
		
		if(pesquisa.equals("todos")) {
			consulta = em.createQuery("SELECT c FROM Categoria c");
		}
		else if(pesquisa.equals("categoria")) {
			consulta = em.createQuery("SELECT c FROM Categoria c WHERE c.descricao = '" +parametro+ "'");
		}
	
		
		categoria = consulta.getResultList();
		em.getTransaction().commit();
		
		em.close();
		
		return categoria;
	}
}