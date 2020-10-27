package br.edu.unifacear.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Marca;
import util.copy.Conexao;

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
		else if(pesquisa.equals("marca")) {
			consulta = em.createQuery("SELECT m FROM Marca m WHERE m.descricao = '"+ marca.getDescricao() +"'");
		}
		em.getTransaction().commit();
		
		lista = consulta.getResultList();
		
		return lista;
		
	}
	public void salvar(Marca marca) throws Exception {
		
		EntityManager em = Conexao.getEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			if(marca.getId() == 0) {
				em.persist(marca);
			}else {
				em.merge(marca);
			}
			em.getTransaction().commit();
			
			
			
		}catch(Exception e) {
			throw new Exception("Erro ao salvar produto");
		}
		
	}

	
	
	
	
	
	

}
