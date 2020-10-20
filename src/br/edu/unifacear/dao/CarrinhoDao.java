package br.edu.unifacear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.classes.Marca;

public class CarrinhoDao {
	public List<Carrinho> listar(String pesquisa, Carrinho parametro){
		
		EntityManager em = Fabrica.getEntityManager();
		
		List<Carrinho> lista = null;
		
		Query consulta = null;
		
		em.getTransaction().begin();
		
		if(pesquisa.equals("exibirCarrinho")) {
			consulta = em.createQuery("SELECT c FROM Carrinho c INNER JOIN ItemDoCarrinho i ON c.idCarrinho = i.carrinho.idCarrinho");
		}
		else if(pesquisa.equals("exibirCarrinhoCliente")) {
			consulta = em.createQuery("SELECT c FROM Carrinho c WHERE cliente_idCliente = "+parametro.getCliente().getId());
		}
		em.getTransaction().commit();
		
		lista = consulta.getResultList();
		
		return lista;
		
	}
}
