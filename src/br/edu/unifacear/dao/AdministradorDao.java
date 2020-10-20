package br.edu.unifacear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Administrador;

public class AdministradorDao {
	
	@SuppressWarnings("unchecked")
	public List<Administrador> listar(Administrador adm, String pesquisa){
		
		EntityManager em = Fabrica.getEntityManager();
		
		Query consulta = null;
		
		List<Administrador> lista;
		
		em.getTransaction().begin();
		
		
		if(pesquisa.equals("todos")) {
			consulta = em.createQuery("SELECT adm FROM Administrador adm");
		}
		
		em.getTransaction().commit();
		
		lista = consulta.getResultList();
		
		return lista;
		
	}
	
}
