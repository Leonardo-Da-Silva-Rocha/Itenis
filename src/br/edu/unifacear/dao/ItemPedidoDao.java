package br.edu.unifacear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.ItemPedido;
import util.copy.Conexao;

public class ItemPedidoDao {

	public void salvar(ItemPedido item) throws Exception {

		try {

			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.persist(item);
			em.getTransaction().commit();

			System.out.println("salvo");

		} catch (Exception e) {

			throw new Exception("ERRO A O SALVAR Pedido");
		}

	}

	public void alterar(ItemPedido item) throws Exception {

		try {

			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			em.merge(item);
			em.getTransaction().commit();

		} catch (Exception e) {

			throw new Exception("Erro ao alterar item do pedido");
		}

	}
	
	public List<ItemPedido> listar(int id) {

		EntityManager em = Fabrica.getEntityManager();

		List<ItemPedido> lista = null;

		Query consulta = null;

		em.getTransaction().begin();

		consulta = em.createQuery("SELECT p FROM ItemPedido p WHERE p.pedido.idPedido = " + id);

		em.getTransaction().commit();

		lista = consulta.getResultList();

		return lista;

	}

}
