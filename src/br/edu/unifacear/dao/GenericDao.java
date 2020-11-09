package br.edu.unifacear.dao;

import javax.persistence.EntityManager;

import br.edu.unifacear.classes.EntityBase;

public class GenericDao<T extends EntityBase>  {
	
	private static EntityManager em = Fabrica.getEntityManager();
	
	public void saveOrUpdate(T obj) throws Exception{
		
		try{
			
			em.getTransaction().begin();
			
			if(obj.getId() == 0){
				em.persist(obj);
			}		
			else {
				em.merge(obj);
			}
			em.getTransaction().commit();
			
		}
		catch(Exception e){
			throw new Exception("Erro Gravando \n"+e.getMessage());
		}
	}
	
	public void remove(Class<T> classe, int id) throws Exception{
		
		T t = findById(classe, id);
		
		try{
			
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
			
		}catch (Exception e) {
			
			em.getTransaction().rollback();
			throw new Exception("Erro Deletando \n"+e.getMessage());
			
		}		
	}
	
	public T findById(Class<T> classe, int id) {
		
		return em.find(classe, id);
		
	}
	
}
