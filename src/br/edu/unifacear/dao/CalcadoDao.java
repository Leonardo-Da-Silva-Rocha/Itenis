package br.edu.unifacear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Calcado;


public class CalcadoDao {
	
	
	@SuppressWarnings("unchecked")
	public List<Calcado> listar(String pesquisa, Calcado parametro, String parametro2){
		
		Query consulta = null;
		List<Calcado> calcado = null;
		
		EntityManager em = Fabrica.getEntityManager();
		
		em.getTransaction().begin();
		
		if(pesquisa.equals("todos")) {
			 consulta = em.createQuery("SELECT c FROM Calcado c");
			 
		}
		else if(pesquisa.equals("categoria")){
			consulta = em.createQuery("SELECT c FROM Calcado c INNER JOIN Categoria t ON c.categoria.idCategoria = t.idCategoria WHERE t.descricao = '" +parametro2+"'");
		
		}
		else if(pesquisa.equals("marca")) {
			consulta = em.createQuery("SELECT c FROM Calcado c INNER JOIN Marca m ON c.marca.idMarca = m.idMarca WHERE m.descricao = '" +parametro2+"'");
		}
		
		
		calcado = consulta.getResultList();
		em.getTransaction().commit();
		
		em.close();
		
		return calcado;
		
	}
	
}
