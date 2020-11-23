package br.edu.unifacear.testes;

import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.ItemPedido;
import br.edu.unifacear.classes.Pedido;
import br.edu.unifacear.classes.Vendedor;
import br.edu.unifacear.facade.CriarPedidoFacade;

public class FacadePedidoTeste {

	public static void main(String[] args) throws Exception {
		
		CriarPedidoFacade facade = new CriarPedidoFacade();
		ItemPedido item = new ItemPedido();
		Vendedor vend = new Vendedor();
		Cliente cli = new Cliente();
		Pedido pedido = new Pedido();
		Calcado cal = new Calcado();
		
		cal.setIdCalcado(1);
		cli.setIdCliente(1);
		vend.setIdVendedor(1);
		
		pedido.setCliente(cli);
		pedido.setVendedor(vend);
		
		
		facade.salvarPedido(pedido);
		
		item.setCalcado(cal);
		item.setPedido(pedido);
		
		facade.salvarItem(item);
		
	}

}
