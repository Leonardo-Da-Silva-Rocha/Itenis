package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Marca;
import br.edu.unifacear.facade.CalcadoFacade;

@ManagedBean(name="imagemBean")
@RequestScoped
public class ImagemController {

	private List<Calcado> imagens;
	
	private Calcado calcado;
	
	private String caminho;
	
	private String descricao;
	
	private String valor;
	
	private String quantidade;

	private String numero;
	
	

	public ImagemController() throws Exception {
		
		this.imagens =  new ArrayList<>();
		adicionaLista(new Calcado(), "todos","");
	}
	
	

	
	public Calcado getCalcado() {
		return calcado;
	}




	public void setCalcado(Calcado calcado) {
		this.calcado = calcado;
	}




	public List<Calcado> getImagens() {
		return imagens;
	}




	public void setImagens(List<Calcado> imagens) {
		this.imagens = imagens;
	}




	public String getCaminho() {
		if(imagens.size() > 0) {
			this.caminho = imagens.get(0).getImagem();
		}
		else {
			this.caminho = "";
		}
		
		return caminho;
	}




	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}




	public String getDescricao() {
		if(imagens.size() > 0) {
			this.descricao = imagens.get(0).getDescricao();
		}
		else {
			this.descricao = "Produto Indisponivel";
		}
		
		return descricao;
	}

	public String getMarca() {
		
		if(imagens.size() > 0) {
			return this.imagens.get(0).getMarca().getDescricao();
		}
		else {
			return "";
		}
		
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public String getValor() {
		if(imagens.size() > 0) {
			this.valor = imagens.get(0).getValor().toString();
			this.imagens.remove(0);
		}
		else {
			this.valor = "";
		}
		
		
		return valor;
	}




	public void setValor(String valor) {
		this.valor = valor;
	}




	public String getQuantidade() {
		return quantidade;
	}




	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}




	public String getNumero() {
		return numero;
	}




	public void setNumero(String numero) {
		this.numero = numero;
	}




	public Calcado getCalcadoImagem() {
		
		Calcado cal = this.imagens.get(0);
		
		this.imagens.remove(0);
		
		return cal;
		
		
	}
	
	
	public void adicionaLista(Calcado calcado, String pesquisa, String parametro) throws Exception{
		
		CalcadoFacade facade = new CalcadoFacade();
		
		for (Calcado calcado2 : facade.listar(calcado, "todos", "")) {
			this.imagens.add(calcado2);
		}
	}
	
	
	
}
