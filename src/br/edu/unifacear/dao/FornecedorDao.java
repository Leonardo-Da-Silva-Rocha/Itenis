package br.edu.unifacear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Fornecedor;
import util.copy.Conexao;

public class FornecedorDao {
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listar(String pesquisa , Fornecedor parametro){
		
		
		Query consulta = null;
		List<Fornecedor> fornecedor = null;
		
		EntityManager em = Fabrica.getEntityManager();
		
		em.getTransaction().begin();
		
		if(pesquisa.equals("todos")) {
			 consulta = em.createQuery("SELECT f FROM Fornecedor f");
			 
		}
		else if(pesquisa.equals("fornecedor")) {
			 consulta = em.createQuery("SELECT f FROM Fornecedor f WHERE f.descricao = '"+ parametro.getDescricao() +"'");
		}
		
		fornecedor = consulta.getResultList();
		em.getTransaction().commit();
		
		em.close();
		
		return fornecedor;
		
	}
	
	public void alterar(Fornecedor fornecedor) throws Exception {
		
		EntityManager em = Conexao.getEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			
			em.merge(fornecedor);
			
			em.getTransaction().commit();
			
			
			
		}catch(Exception e) {
			throw new Exception("Erro ao salvar fornecedor");
		}
		
		
	}
	
}