package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.ItemDoCarrinho;
import br.edu.unifacear.facade.CadastrarClienteFacade;
import br.edu.unifacear.facade.ClienteFacade;
import br.edu.unifacear.facade.ItemCarrinhoFacade;


@ManagedBean(name="clienteBean")
@SessionScoped
public class ClienteController {
	
	private ItemDoCarrinho item;
	private Cliente cliente;
	private Calcado calcadoSelecionado;
	
	
	
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
		this.calcadoSelecionado = new Calcado();
		this.item = new ItemDoCarrinho();
		this.cliente = new Cliente();
	
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
	
	public String logar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			ClienteFacade facade = new ClienteFacade();
			
			
			facade.login(cliente);
			
			this.cliente.setCarrinho(facade.carrinho(cliente).get(0));
			
			
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
			
			itemFacade.adicionarProduto(item, this.calcadoSelecionado);
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage() ,""));
		}
		
		
		
	}
	
	
}
