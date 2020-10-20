package br.edu.unifacear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import br.edu.unifacear.classes.TipoEntrega;

public class TipoEntregaDao {
	
	@SuppressWarnings({ "unchecked" })
	public List<TipoEntrega> listar(String pesquisa, TipoEntrega parametro){
		
		EntityManager em = Fabrica.getEntityManager();
		
		List<TipoEntrega> lista = null;
		
		Query consulta = null;
		
		em.getTransaction().begin();
		
		if(pesquisa.equals("todos")) {
			consulta = em.createQuery("SELECT t FROM TipoEntrega t");
		}
		
		em.getTransaction().commit();
		
		lista = consulta.getResultList();
		
		return lista;
		
	}
	
}
