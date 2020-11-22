package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.ItemDoCarrinho;
import br.edu.unifacear.classes.Vendedor;
import br.edu.unifacear.facade.CadastrarClienteFacade;
import br.edu.unifacear.facade.CalcadoFacade;
import br.edu.unifacear.facade.ClienteFacade;
import br.edu.unifacear.facade.ItemCarrinhoFacade;
import br.edu.unifacear.facade.VendedorFacade;


@ManagedBean(name="clienteBean")
@SessionScoped
public class ClienteController {
	
	private int login;
	private String emailUsuario;
	private String senhaUsuario;
	private Double total;
	private int quantidade;
	private ItemDoCarrinho item;
	private Cliente cliente;
	private String pesquisa;
	private Calcado calcadoSelecionado;
	public List<ItemDoCarrinho> itens;
	
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
		
		this.itens = new ArrayList<>();
		this.calcadoSelecionado = new Calcado();
		this.item = new ItemDoCarrinho();
		this.cliente = new Cliente();
		this.total = 0.0;
		this.pesquisa = "";
		this.login = 0;
	}
	
	
	public void salvar() throws Exception {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		
		try {
			
			CadastrarClienteFacade facade = new CadastrarClienteFacade();
			facade.salvar(this.cliente.getEndereco(), this.cliente, new Carrinho());
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Cadastrado com sucesso no site",""));
			
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao salvar ","verifique se o email ja esta em uso em nosso site e se as senhas são iguais"));
		}
		
		
		
	}

	public void adicionarAoCarrinho() {
		
		
		FacesContext context = FacesContext.getCurrentInstance();
		this.item = new ItemDoCarrinho();
		ItemCarrinhoFacade itemFacade = new ItemCarrinhoFacade();
		

		try {
			
			this.item.setCalcado(this.calcadoSelecionado);
			this.item.setCarrinho(this.cliente.getCarrinho());
			this.item.setQuantidade(this.quantidade);
			itemFacade.adicionarProduto(item, this.calcadoSelecionado);
			
			atualizar();
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage() ,""));
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
				
				if(cli.getEmail().equals(this.emailUsuario)) {
					
					this.login = 1;
					
					if(cli.getSenha().equals(this.senhaUsuario)) {
						
						
						this.cliente = cli;
						this.cliente.setCarrinho(facade.carrinho(cliente).get(0));
						this.total = 0.0;
						
						valorTotal();
						
						
						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"cli" ,""));
						
						return "cli";
						
					}
					else {
						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Erro Email ou senha invalido" ,""));
					}
					
				}
				
			}
			
			for (Vendedor vendedor : vend.listar("todos")) {
				
				if(vendedor.getEmail().equals(this.emailUsuario)) {
					
					this.login = 1;
					
					if(vendedor.getSenha().equals(this.senhaUsuario)) {
						
						
						
						VendedorController c = new VendedorController();
						
						c.setVendedor(vendedor);
						
						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"vend" ,""));
						
						return "vend";
						
					}
					else {
						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Erro Email ou senha invalido" ,""));
					}
					
				}
				
			}
			
			if(login == 0) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro Realize um cadastro no site" ,""));
			}
			
			this.login = 0;
			
			return "erro";
			
		}catch(Exception e) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro Email ou senha invalido" ,""));
			
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
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Item alterardo com sucesso!",""));
			
			
		}catch(Exception e) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
			
		}
		
	}
	
	public void removerItem() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			ItemCarrinhoFacade facade = new ItemCarrinhoFacade();
			
			facade.remover(this.item);
			this.cliente.getCarrinho().getItem().remove(this.item);
			atualizarEstoque(this.item);
			valorTotal();
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Item removido com sucesso!",""));
			
			
		}catch(Exception e) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
			
		}
		
	}
	
	public void atualizarEstoque(ItemDoCarrinho item) throws Exception {
		
		item.getCalcado().setQuantidade(item.getQuantidade() + item.getCalcado().getQuantidade());
		CalcadoFacade facade = new CalcadoFacade();
		facade.alterar(item.getCalcado());
	}
}