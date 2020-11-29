package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.ItemDoCarrinho;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.dao.ItemDoCarrinhoDao;

public class ItemDoCarrinhoBo {

	public void salvar(ItemDoCarrinho item, int quantidadeCalcado, Cliente cli) throws Exception {

		

		item.setValor(item.getQuantidade() * item.getCalcado().getValor());
		validarQuantidade(item, item.getCalcado().getQuantidade());
		if(cli.getCarrinho().getItem().size() > 0) {
			for (ItemDoCarrinho itemC : cli.getCarrinho().getItem()) {

				

				if (item.getCalcado().getDescricao().equals(itemC.getCalcado().getDescricao())) {
					if(item.getCalcado().getNumero() == itemC.getCalcado().getNumero()) {
						
						throw new Exception("Erro este item ja esta em seu carrinho");
					}
					else {
					
						new GenericDao().saveOrUpdate(item);
					}
					

				}else {
					new GenericDao().saveOrUpdate(item);
				}
			}
		}
		else {
			new GenericDao().saveOrUpdate(item);
		}
		
		

	}

	public void alterar(ItemDoCarrinho item) throws Exception {

		validarQuantidade(item, item.getCalcado().getQuantidade());

		item.setValor(item.getQuantidade() * item.getCalcado().getValor());

		try {
			new GenericDao().saveOrUpdate(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void validarQuantidade(ItemDoCarrinho item, int quantidade) throws Exception {

		if (item.getQuantidade() < 0) {
			throw new Exception("Erro, quantidade do produto nao pode ser menor que zero");
		} else if (item.getQuantidade() > quantidade) {
			throw new Exception("Erro, nao temos essa quantidade de produto no momento, no momento temos " + quantidade
					+ " unidades");
		}

	}

	public List<ItemDoCarrinho> listar(String pesquisa, ItemDoCarrinho parametro) throws Exception {

		try {

			return new ItemDoCarrinhoDao().listar(pesquisa, parametro);

		} catch (Exception e) {

			throw new Exception("Erro ao listar");

		}
	}

	

	public void remover(ItemDoCarrinho item) throws Exception {
		
		try {
			item.setCalcado(null);
			item.setCarrinho(null);
			

			new GenericDao().saveOrUpdate(item);
			

		} catch (Exception e) {
			throw new Exception("Errro ao remover este item");
		}
	}

	public void readicionar(ItemDoCarrinho item) throws Exception {
		validarQuantidade(item, item.getCalcado().getQuantidade());
		item.setValor(item.getQuantidade() * item.getCalcado().getValor());
		try {
			new GenericDao().saveOrUpdate(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void removerItens(List<ItemDoCarrinho> itens) throws Exception {
		
		for (ItemDoCarrinho item : itens) {
			
			
			try {
				item.setCalcado(null);
				item.setCarrinho(null);
				new GenericDao().saveOrUpdate(item);
				
				
			}catch(Exception e) {
				throw new Exception("Falha ao apagar");
			}
			
			
		}
		
	}
	
}