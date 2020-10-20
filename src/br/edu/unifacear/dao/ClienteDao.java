package br.edu.unifacear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Cliente;

public class ClienteDao {
	
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listar(String pesquisa, Cliente parametro){
		
		Query consulta = null;
		List<Cliente> cliente = null;
		
		EntityManager em = Fabrica.getEntityManager();
		
		em.getTransaction().begin();
		
		if(pesquisa.equals("todos")) {
			 consulta = em.createQuery("SELECT c FROM Cliente c");
			 
		}
		
		
		
		cliente = consulta.getResultList();
		em.getTransaction().commit();
		
		em.close();
		
		return cliente;
		
	}
	
}
