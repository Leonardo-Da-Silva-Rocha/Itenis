package br.edu.unifacear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Comissao;

public class ComissaoDao {

	public List<Comissao> listar(int parametro) {

		EntityManager em = Fabrica.getEntityManager();

		Query consulta = null;

		List<Comissao> lista;

		em.getTransaction().begin();

		consulta = em.createQuery("SELECT c FROM Comissao c WHERE c.vendedor.idVendedor =  "+parametro);

		em.getTransaction().commit();

		lista = consulta.getResultList();

		return lista;

	}
}
