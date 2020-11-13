package br.edu.unifacear.dao;



import javax.persistence.EntityManager;

import br.edu.unifacear.classes.ItemPedido;

public class ItemPedidoDao {
	
	public void salvar(ItemPedido item) throws Exception {
		
		
		
		try {
			
			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			em.persist(item);
			em.getTransaction().commit();
			
			
			
		}catch(Exception e) {
		
			throw new Exception("ERRO A O SALVAR Pedido");
		}
		
	
		
	}
	
}
