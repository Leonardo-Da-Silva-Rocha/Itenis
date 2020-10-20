package br.edu.unifacear.testes;

import br.edu.unifacear.bo.CarrinhoBo;
import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.classes.Cliente;

public class MostrarCarrinho {

	public static void main(String[] args) {
		
		Carrinho c = new Carrinho();
		Cliente cli = new Cliente();
		cli.setIdCliente(1);
		
		c.setIdCarrinho(13);
		
		try {
			
			for (Carrinho  ca : new CarrinhoBo().listar("exibirCarrinho", c)) {
				
				for (int i = 0; i < ca.getItem().size(); i++) {
					
					System.out.println("quantidade = "+ca.getItem().get(i).getQuantidade());
					System.out.println("Descricao = "+ca.getItem().get(i).getCalcado().getDescricao());
					System.out.println("Numero = "+ca.getItem().get(i).getCalcado().getNumero());
					System.out.println("Categoria = "+ca.getItem().get(i).getCalcado().getCategoria().getDescricao());
					
				}
				
				
				System.out.println("Cliente = "+ca.getCliente().getNome());
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
