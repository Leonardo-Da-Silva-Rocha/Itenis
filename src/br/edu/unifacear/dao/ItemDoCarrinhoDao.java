package br.edu.unifacear.dao;




import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.ItemDoCarrinho;

public class ItemDoCarrinhoDao {

	@SuppressWarnings("unchecked")
	public List<ItemDoCarrinho> listar(String pesquisa, ItemDoCarrinho parametro) {
		
		Query consulta = null;
		List<ItemDoCarrinho> item = null;
		
		EntityManager em = Fabrica.getEntityManager();
		
		em.getTransaction().begin();
		
		if(pesquisa.equals("validarQuantidade")) {
			 consulta = em.createQuery("SELECT i FROM ItemDoCarrinho i WhERE i.calcado.idCalcado = calcado_idCalcado");
			 
		}
		
		else if(pesquisa.equals("itens")) {
			consulta = em.createQuery("SELECT i FROM ItemDoCarrinho i INNER JOIN Calcado c on i.calcado.idCalcado = c.idCalcado WHERE i.idItemDoCarrinho = "+parametro.getId());
		}
		else if(pesquisa.equals("itensParametro")) {
			consulta = em.createQuery("SELECT i FROM ItemDoCarrinho i WHERE carrinho_idCarrinho = "+1);
		}
		
		item = consulta.getResultList();
		em.getTransaction().commit();
		
		em.close();
		
		return item;
	}
}