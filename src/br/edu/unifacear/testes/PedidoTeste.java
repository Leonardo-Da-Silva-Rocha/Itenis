package br.edu.unifacear.testes;

import br.edu.unifacear.bo.CarrinhoBo;
import br.edu.unifacear.bo.ItemPedidoBo;
import br.edu.unifacear.bo.PedidoBo;
import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.ItemPedido;
import br.edu.unifacear.classes.Pedido;
import br.edu.unifacear.classes.TipoEntrega;
import br.edu.unifacear.classes.Vendedor;
import br.edu.unifacear.dao.GenericDao;

public class PedidoTeste {

	public static void main(String[] args) {
		
		Vendedor vend = new Vendedor();
		vend.setIdVendedor(1);
		
		TipoEntrega tipo = new TipoEntrega();
		tipo.setIdTipoEntrega(1);
		
		Cliente cli = new Cliente();
		cli.setIdCliente(1);
		
		Carrinho carro = new Carrinho();
		carro.setCliente(cli);
		
		ItemPedido itemPedido = new ItemPedido();
		
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cli);
		pedido.setEnderecoDeEntrega("r. andorinhas 123, Contenda");
		pedido.setTipo(tipo);
		pedido.setVendedor(vend);
		
		
		try {
			new GenericDao().saveOrUpdate(pedido);
			System.out.println("Pedido Salvo");
		}catch(Exception e) {
			System.out.println("Erro ao salvar pedido");
		}
	
	
		
		try {
			carro = new CarrinhoBo().listar("exibirCarrinhoCliente", carro).get(0);
		}catch(Exception e) {
			System.out.println("Erro carinho");
		}
		
		
		
		System.out.println(carro.getItem().get(2).getCalcado().getDescricao());
		for (int i = 0; i < carro.getItem().size(); i++) {
			
			itemPedido.setQuantidade(carro.getItem().get(i).getQuantidade());
			itemPedido.setPedido(pedido);
			itemPedido.setCalcado(carro.getItem().get(i).getCalcado());
			
			try {
				new ItemPedidoBo().salvar(itemPedido);
				System.out.println("Item Do Pedido Salvo");
			}catch(Exception e) {
				System.out.println("erro pedido");
			}
			
			itemPedido = new ItemPedido();
		}	
		
		
		try {
			pedido = new PedidoBo().listar("meuPedido", pedido).get(0);
		}catch(Exception e) {
			System.out.println("listado");
		}
		
		pedido = new PedidoBo().valorTotalDoPedido(pedido);
		
		try {
			new GenericDao().saveOrUpdate(pedido);
			System.out.println("Preco do pedido alterado");
		}catch(Exception e) {
			System.out.println("Erro ao alterar");
		}
			
	}
}