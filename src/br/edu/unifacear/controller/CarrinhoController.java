package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Carrinho;
import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.ItemDoCarrinho;
import br.edu.unifacear.facade.CarrinhoFacade;
@ManagedBean(name="carrinhoBean")
@SessionScoped
public class CarrinhoController {
	
	private Carrinho carrinho;
	private ItemDoCarrinho item;
	private Calcado calcadoSelecionado;
	
	
	public Calcado getCalcadoSelecionado() {
		return calcadoSelecionado;
	}

	public void setCalcadoSelecionado(Calcado calcadoSelecionado) {
		this.calcadoSelecionado = calcadoSelecionado;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public CarrinhoController() {
		this.calcadoSelecionado = new Calcado();
		this.item = new ItemDoCarrinho();
		this.carrinho = new Carrinho();
	}
	
	
	
	public ItemDoCarrinho getItem() {
		return item;
	}

	public void setItem(ItemDoCarrinho item) {
		this.item = item;
	}

	public String salvar(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			CarrinhoFacade facade = new CarrinhoFacade();
			facade.criarCarrinho(this.carrinho);
			
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(),""));
		}
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Carrinho criado",""));
		return "Carrinho criado";
		
	}
	
	
	
	public void adicionarAoCarrinho() {
		
		
		
		
		try {
			this.item.setCalcado(this.calcadoSelecionado);
			this.item.setCarrinho(carrinho);
		}catch(Exception e) {
			
		}
		
		
		
	}
	
	
}
