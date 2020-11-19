package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.ItemDoCarrinho;
import br.edu.unifacear.facade.CadastrarClienteFacade;
import br.edu.unifacear.facade.CalcadoFacade;
import br.edu.unifacear.facade.CarrinhoFacade;
import br.edu.unifacear.facade.ClienteFacade;
import br.edu.unifacear.facade.ItemCarrinhoFacade;


@ManagedBean(name="clienteBean")
@SessionScoped
public class ClienteController {
	
	private Double total;
	private int quantidade;
	private ItemDoCarrinho item;
	private Cliente cliente;
	private String pesquisa;
	private Calcado calcadoSelecionado;
	public List<ItemDoCarrinho> itens;
	
	
	
	
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
					"Erro ao salvar ","verifique se o email ja esta em uso em nosso site e se as senhas s�o iguais"));
		}
		
		
		
	}
	
	public String logar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			ClienteFacade facade = new ClienteFacade();
			
			
			facade.login(cliente);
			
			this.cliente.setCarrinho(facade.carrinho(cliente).get(0));
			this.total = 0.0;
			total();
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Bem vindo" ,""));
			
			return "logado"; 
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
			
			return "erro ao logar";
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
	
	
	
	
	
	public void total() {
		
		
		for (ItemDoCarrinho itemDoCarrinho : this.cliente.getCarrinho().getItem()) {
			
			this.total = this.total + itemDoCarrinho.getValor();
		}
		
		
		
		
		
	}
	
}
