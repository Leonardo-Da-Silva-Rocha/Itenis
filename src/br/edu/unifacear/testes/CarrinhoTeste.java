package br.edu.unifacear.testes;

import br.edu.unifacear.bo.ItemDoCarrinhoBo;
import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.ItemDoCarrinho;
import br.edu.unifacear.dao.GenericDao;

public class CarrinhoTeste {

	public static void main(String[] args) {
		
		ItemDoCarrinho i = new ItemDoCarrinho();
		
		Carrinho c = new Carrinho();

		Cliente cli = new Cliente();
		
		Calcado cal = new Calcado();
		
		cli.setIdCliente(1);

		cal.setIdCalcado(3);
		cal.setQuantidade(9);
		cal.setValor(450.00);
		
		c.setIdCarrinho(1);
		c.setCliente(cli);
		
		
		i.setQuantidade(1);
		i.setCalcado(cal);
		i.setCarrinho(c);
		
		cli.setCarrinho(c);
		
		try {//add
			new ItemDoCarrinhoBo().salvar(i, cal.getQuantidade());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	
	}

}
