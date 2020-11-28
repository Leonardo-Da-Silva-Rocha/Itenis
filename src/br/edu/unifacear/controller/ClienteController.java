package br.edu.unifacear.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Administrador;
import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.Comissao;
import br.edu.unifacear.classes.ItemDoCarrinho;
import br.edu.unifacear.classes.ItemPedido;
import br.edu.unifacear.classes.Pedido;
import br.edu.unifacear.classes.Vendedor;
import br.edu.unifacear.facade.AdministradorFacade;
import br.edu.unifacear.facade.CadastrarClienteFacade;
import br.edu.unifacear.facade.CalcadoFacade;
import br.edu.unifacear.facade.ClienteFacade;
import br.edu.unifacear.facade.ComissaoFacade;
import br.edu.unifacear.facade.CriarPedidoFacade;
import br.edu.unifacear.facade.EnderecoFacade;
import br.edu.unifacear.facade.ItemCarrinhoFacade;
import br.edu.unifacear.facade.ItemPedidoFacade;
import br.edu.unifacear.facade.PedidoFacade;
import br.edu.unifacear.facade.VendedorFacade;

@ManagedBean(name = "clienteBean")
@SessionScoped
public class ClienteController {

	private int login;
	private String emailUsuario;
	private String senhaUsuario;
	private Double total;
	private Double valorTotalComissao;
	private ItemPedido itemPedido;
	private int quantidade;
	private int idVendedor;
	private int idAdm;
	private ItemDoCarrinho item;
	private ItemDoCarrinho removerItemSelecionado;
	private Pedido pedido;
	private Cliente cliente;
	private String pesquisa;
	private Calcado calcadoSelecionado;
	private List<Comissao> comissao;
	private List<Pedido> pedidos;
	private List<ItemPedido> itensDoPedido;
	private List<ItemDoCarrinho> itens;
	private String formaPagamento;
	private List<ItemPedido> comprasCliente;

	public Double getValorTotalComissao() {
		return valorTotalComissao;
	}

	public void setValorTotalComissao(Double valorTotalComissao) {
		this.valorTotalComissao = valorTotalComissao;
	}

	public List<Comissao> getComissao() {
		return comissao;
	}

	public void setComissao(List<Comissao> comissao) {
		this.comissao = comissao;
	}

	public ItemDoCarrinho getRemoverItemSelecionado() {
		return removerItemSelecionado;
	}

	public void setRemoverItemSelecionado(ItemDoCarrinho removerItemSelecionado) {
		this.removerItemSelecionado = removerItemSelecionado;
	}

	public List<ItemPedido> getComprasCliente() {
		return comprasCliente;
	}

	public void setComprasCliente(List<ItemPedido> comprasCliente) {
		this.comprasCliente = comprasCliente;
	}

	public int getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(int idAdm) {
		this.idAdm = idAdm;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<ItemPedido> getItensDoPedido() {
		return itensDoPedido;
	}

	public void setItensDoPedido(List<ItemPedido> itensDoPedido) {
		this.itensDoPedido = itensDoPedido;
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<ItemDoCarrinho> getItens() {
		return itens;
	}

	public void setItens(List<ItemDoCarrinho> itens) {
		this.itens = itens;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Calcado getCalcadoSelecionado() {
		return calcadoSelecionado;
	}

	public void setCalcadoSelecionado(Calcado calcadoSelecionado) {
		this.calcadoSelecionado = calcadoSelecionado;
	}

	public ItemDoCarrinho getItem() {
		return item;
	}

	public void setItem(ItemDoCarrinho item) {
		this.item = item;
	}

	public Cliente getCliente() {
		return cliente;

	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteController() {
		this.removerItemSelecionado = new ItemDoCarrinho();
		this.comprasCliente = new ArrayList<>();
		this.pedidos = new ArrayList<>();
		this.itemPedido = new ItemPedido();
		this.valorTotalComissao = 0.0;
		this.itensDoPedido = new ArrayList<>();
		this.pedido = new Pedido();
		this.itens = new ArrayList<>();
		this.comissao = new ArrayList<>();
		this.calcadoSelecionado = new Calcado();
		this.item = new ItemDoCarrinho();
		this.cliente = new Cliente();
		this.idVendedor = 0;
		this.total = 0.0;
		this.pesquisa = "";
		this.login = 0;
	}

	public void salvar() throws Exception {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			CadastrarClienteFacade facade = new CadastrarClienteFacade();
			facade.salvar(this.cliente.getEndereco(), this.cliente, new Carrinho());

			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cadastrado com sucesso no site", ""));

		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar ",
					"verifique se o email ja esta em uso em nosso site e se as senhas são iguais"));
		}

	}

	public void adicionarAoCarrinho() {

		FacesContext context = FacesContext.getCurrentInstance();
		this.item = new ItemDoCarrinho();
		ItemCarrinhoFacade itemFacade = new ItemCarrinhoFacade();

		try {

			this.item.setCalcado(this.calcadoSelecionado);
			this.item.setCarrinho(this.cliente.getCarrinho());
			this.item.setQuantidade(1);
			itemFacade.adicionarProduto(item, this.calcadoSelecionado);
			this.itens.add(this.item);
			this.cliente.getCarrinho().setItem(this.itens);
			atualizar();
			valorTotal();

		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

	}

	public void atualizar() throws Exception {

		CalcadoFacade facade = new CalcadoFacade();
		this.calcadoSelecionado.setQuantidade(this.calcadoSelecionado.getQuantidade() - this.quantidade);
		facade.alterar(this.calcadoSelecionado);
	}

	public String loginDinamico() {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			ClienteFacade facade = new ClienteFacade();
			VendedorFacade vend = new VendedorFacade();

			for (Cliente cli : facade.listar("todos", cliente)) {

				if (cli.getEmail().equals(this.emailUsuario)) {

					this.login = 1;

					if (cli.getSenha().equals(this.senhaUsuario)) {

						this.cliente = cli;
						this.cliente.setCarrinho(facade.carrinho(cliente).get(0));
						this.total = 0.0;

						comprasCliente();
						valorTotal();

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "cli", ""));

						return "TelaInicial.xhtml?faces-redirect=true";

					} else {
						context.addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Email ou senha invalido", ""));
					}

				}

			}

			for (Vendedor vendedor : vend.listar("todos")) {

				if (vendedor.getEmail().equals(this.emailUsuario)) {

					this.login = 1;

					if (vendedor.getSenha().equals(this.senhaUsuario)) {
						VendedorController c = new VendedorController();
						c.setVendedor(vendedor);
						this.idVendedor = c.getVendedor().getIdVendedor();
						this.comissao = new ComissaoFacade().listar(this.idVendedor);
						totalComissao();

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "vend", ""));

						return "vend";

					} else {
						context.addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Email ou senha invalido", ""));
					}

				}

			}

			for (Administrador ad : new AdministradorFacade().listar(new Administrador(), "todos")) {

				if (ad.getEmail().equals(this.emailUsuario)) {

					if (ad.getSenha().toUpperCase().equals(this.senhaUsuario.toUpperCase())) {
						this.idVendedor = 0;
						System.out.println("ola");
						this.login = 1;
						this.idAdm = ad.getIdAdministrador();
						return "vend";

					} else {
						context.addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Email ou senha invalido", ""));
					}
				}
			}

			if (login == 0) {
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Realize um cadastro no site", ""));
			}

			this.login = 0;

			return "erro";

		} catch (Exception e) {

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Email ou senha invalido", ""));

			return "erro";
		}

	}

	public void valorTotal() {

		this.total = 0.0;

		for (ItemDoCarrinho itemDoCarrinho : this.cliente.getCarrinho().getItem()) {

			this.total = this.total + itemDoCarrinho.getValor();

		}

	}

	public void alterarItem() {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			ItemCarrinhoFacade facade = new ItemCarrinhoFacade();

			facade.alterar(this.item);

			valorTotal();

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Item alterardo com sucesso!", ""));

		} catch (Exception e) {

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));

		}

	}

	public void removerItem() {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			ItemCarrinhoFacade facade = new ItemCarrinhoFacade();

			this.cliente.getCarrinho().getItem().remove(this.removerItemSelecionado);
			facade.remover(this.removerItemSelecionado);

			atualizarEstoque(this.removerItemSelecionado);
			valorTotal();

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Item removido com sucesso!", ""));

		} catch (Exception e) {

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));

		}

	}

	public void atualizarEstoque(ItemDoCarrinho item) throws Exception {

		item.getCalcado().setQuantidade(item.getQuantidade() + item.getCalcado().getQuantidade());
		CalcadoFacade facade = new CalcadoFacade();
		facade.alterar(item.getCalcado());
	}

	public String Criarpedido() {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			CriarPedidoFacade facade = new CriarPedidoFacade();
			this.pedido.setCliente(this.cliente);

			valorPedido();
			facade.salvarPedido(pedido);
			CriaritemPedido();

			return "FinalizarPedido.xhtml?faces-redirect=true";

		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			System.out.println("erro");
			return "TelaInicial.xhtml";
		}

	}

	public void valorPedido() {

		for (ItemDoCarrinho item : this.cliente.getCarrinho().getItem()) {

			this.pedido.setPreco(this.pedido.getPreco() + item.getValor());

		}

	}

	public void CriaritemPedido() throws Exception {

		CriarPedidoFacade facade = new CriarPedidoFacade();

		for (ItemDoCarrinho i : this.cliente.getCarrinho().getItem()) {
			this.itemPedido = new ItemPedido();
			this.itemPedido.setCalcado(i.getCalcado());
			this.itemPedido.setPedido(this.pedido);
			this.itemPedido.setQuantidade(i.getQuantidade());
			this.itemPedido.setPreco(i.getValor());
			this.itensDoPedido.add(this.itemPedido);
			facade.salvarItem(this.itemPedido);

		}

	}

	public void EnderecoCliente() {
		FacesContext context = FacesContext.getCurrentInstance();
		EnderecoFacade facade = new EnderecoFacade();
		try {
			facade.salvar(this.cliente.getEndereco());
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	public void finalizar() {
		FacesContext context = FacesContext.getCurrentInstance();
		PedidoFacade facade = new PedidoFacade();
		try {

			this.pedido.setFormaPagamento(this.formaPagamento);
			this.pedido.setStatus(true);
			this.pedido.setEndereco(this.cliente.getEndereco());
			if (this.idVendedor != 0) {
				this.pedido.setVendedor(vendedorPedido());
				comissaoVendedor();
			} else if (this.idAdm != 0) {
				this.pedido.setDataDeEntrega("");
			} else {

				dataEntrega();
			}

			facade.salvar(pedido);
			deletarItemDoCarrinho();

		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

	}

	public void dataEntrega() {
		System.out.println(this.formaPagamento);
		LocalDate localDate = LocalDate.now().plusDays(7);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String formato = formatter.format(localDate);
		this.pedido.setDataDeEntrega(formato);
	}

	public void comprasCliente() {
		FacesContext context = FacesContext.getCurrentInstance();
		PedidoFacade facade = new PedidoFacade();
		ItemPedidoFacade i = new ItemPedidoFacade();
		try {

			this.pedidos = facade.listar("meuPedido", this.cliente.getIdCliente());

			for (Pedido pedido : this.pedidos) {
				for (ItemPedido itemPedido : i.listar(pedido.getIdPedido())) {

					this.comprasCliente.add(itemPedido);
					System.out.println(this.comprasCliente.get(0).getCalcado().getDescricao());
				}
			}

		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

	}

	public String vendedorCompra() {

		FacesContext context = FacesContext.getCurrentInstance();
		ClienteFacade facade = new ClienteFacade();

		try {

			for (Cliente cli : new ClienteFacade().listar("cpf", this.cliente)) {

				this.cliente = new Cliente();
				this.cliente = cli;

				this.cliente.setCarrinho(facade.carrinho(cliente).get(0));
				this.total = 0.0;

				valorTotal();
				comprasCliente();

			}

			return "TelaInicial.xhtml?faces-redirect=true";
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return "TelaPrincipalVendedor.xhtml?faces-redirect=true";
		}

	}

	public String telaVendedor() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (this.idAdm != 0) {

			return "cadastro";
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Contade um administrador para cadastrar um novo vendedor", ""));
			return "TelaPrincipalVendedor.xhtml";
		}

	}

	public void totalComissao() {
		this.valorTotalComissao = 0.0;
		for (Comissao comissao2 : this.comissao) {
			this.valorTotalComissao = this.valorTotalComissao + comissao2.getPorcentagem();
		}
	}

	public Vendedor vendedorPedido() {
		Vendedor ven = new Vendedor();
		ven.setIdVendedor(this.idVendedor);
		return ven;
	}

	public void deletarItemDoCarrinho() {

		ClienteFacade facade = new ClienteFacade();

		ItemCarrinhoFacade item = new ItemCarrinhoFacade();

		try {

			this.itens.removeAll(this.cliente.getCarrinho().getItem());

			for (ItemDoCarrinho cli : this.cliente.getCarrinho().getItem()) {
				item.remover(cli);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void comissaoVendedor() {
		ComissaoFacade facade = new ComissaoFacade();
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String formato = formatter.format(localDate);
		Comissao co = new Comissao();
		Vendedor ven = new Vendedor();
		ven.setIdVendedor(this.idVendedor);
		Double porcentagem = (this.pedido.getPreco() * 5) / 100;
		co.setPorcentagem(porcentagem);
		co.setVendedor(ven);
		co.setDinheiro(this.pedido.getPreco());
		co.setDataPagamento(formato);
		facade.salvar(co);
	}
}