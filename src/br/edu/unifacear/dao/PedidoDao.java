package br.edu.unifacear.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import br.edu.unifacear.classes.Pedido;

public class PedidoDao {
	
	public List<Pedido> listar(String pesquisa, int id){
		
		
		EntityManager em = Fabrica.getEntityManager();
		
		List<Pedido> lista = null;
		
		Query consulta = null;
		
		em.getTransaction().begin();
		
		if(pesquisa.equals("meuPedido")) {
			consulta = em.createQuery("SELECT p FROM Pedido p WHERE p.cliente.idCliente = "+id);
		}
		
		em.getTransaction().commit();
		
		lista = consulta.getResultList();
		
		return lista;
		
	}
	
}
