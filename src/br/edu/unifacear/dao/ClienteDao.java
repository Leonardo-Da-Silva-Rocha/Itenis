package br.edu.unifacear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.Marca;
import util.copy.Conexao;

public class ClienteDao {

	@SuppressWarnings("unchecked")
	public List<Cliente> listar(String pesquisa, Cliente parametro) {

		Query consulta = null;
		List<Cliente> cliente = null;

		EntityManager em = Fabrica.getEntityManager();

		em.getTransaction().begin();

		if (pesquisa.equals("todos")) {
			consulta = em.createQuery("SELECT c FROM Cliente c");

		} else if (pesquisa.equals("cpf")) {
			consulta = em.createQuery("SELECT c FROM Cliente c WHERE c.cpf = " + parametro.getCpf());
		}

		cliente = consulta.getResultList();
		em.getTransaction().commit();

		em.close();

		return cliente;

	}

	public void salvar(Cliente cliente) throws Exception {

		EntityManager em = Conexao.getEntityManager();

		try {

			em.getTransaction().begin();

			em.persist(cliente);

			em.getTransaction().commit();

		} catch (Exception e) {
			throw new Exception("Erro ao salvar cliente");
		}

	}
}
