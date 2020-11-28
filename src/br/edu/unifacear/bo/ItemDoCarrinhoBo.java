package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.ItemDoCarrinho;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.dao.ItemDoCarrinhoDao;

public class ItemDoCarrinhoBo {
	
	public void salvar(ItemDoCarrinho item, int quantidadeCalcado) throws Exception {
		
		validarQuantidade(item, item.getCalcado().getQuantidade());
		valida(item);
		
		item.setValor(item.getQuantidade() * item.getCalcado().getValor());
		
		try {
			new GenericDao().saveOrUpdate(item);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void alterar(ItemDoCarrinho item) throws Exception {
		
		validarQuantidade(item, item.getCalcado().getQuantidade());
		
		
		item.setValor(item.getQuantidade() * item.getCalcado().getValor());
		
		try {
			new GenericDao().saveOrUpdate(item);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void validarQuantidade(ItemDoCarrinho item, int quantidade) throws Exception {
		
			if(item.getQuantidade() < 0) {
				throw new Exception("Erro, quantidade do produto nao pode ser menor que zero");
			}
			else if(item.getQuantidade() > quantidade) {
				throw new Exception("Erro, nao temos essa quantidade de produto no momento, no momento temos "+quantidade+" unidades");
			}
		
	}
	
	public List<ItemDoCarrinho> listar(String pesquisa, ItemDoCarrinho parametro) throws Exception{
		
		try {
			
			return new ItemDoCarrinhoDao().listar(pesquisa, parametro);
			
		}catch(Exception e) {
			
			throw new Exception("Erro ao listar");
			
		}
	}
	
	
	public void valida(ItemDoCarrinho item) throws Exception {
		
		for (ItemDoCarrinho i :new ItemDoCarrinhoDao().listar("validarQuantidade", item)) {
			
			if(i.getCalcado().getDescricao().equals(item.getCalcado().getDescricao())) {
				
				if(i.getCalcado().getNumero() == item.getCalcado().getNumero()) {
					
					throw new Exception("Este Calçado já esta em seu carrinho");
				}
				
			}
			
		}
	}
	
	public void remover(ItemDoCarrinho item) throws Exception {
		try {
			
			new GenericDao().remove(item.getClass(), item.getIdItemDoCarrinho());
			
		}catch(Exception e) {
			throw new Exception("Errro ao remover este item");
		}
	}
	
	public void readicionar(ItemDoCarrinho item) throws Exception {
		validarQuantidade(item, item.getCalcado().getQuantidade());
		item.setValor(item.getQuantidade() * item.getCalcado().getValor());
		try {
			new GenericDao().saveOrUpdate(item);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}