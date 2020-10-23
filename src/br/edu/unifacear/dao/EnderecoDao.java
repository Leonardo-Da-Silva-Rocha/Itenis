package br.edu.unifacear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import br.edu.unifacear.classes.Endereco;

public class EnderecoDao {
	
	public List<Endereco> listar(){
		EntityManager em = Fabrica.getEntityManager();
		
		Query consulta = null;
		
		List<Endereco> lista;
		
		em.getTransaction().begin();
		
		
		
		consulta = em.createQuery("SELECT e FROM Endereco e");
		
		
		em.getTransaction().commit();
		
		lista = consulta.getResultList();
		
		return lista;
	}
	
}
