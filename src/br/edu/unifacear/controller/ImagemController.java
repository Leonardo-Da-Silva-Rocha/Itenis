package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Cliente;
import br.edu.unifacear.classes.ItemDoCarrinho;
import br.edu.unifacear.facade.CalcadoFacade;

@ManagedBean(name="imagemBean")
@RequestScoped
public class ImagemController {

	private List<Calcado> imagens;
	
	private ItemDoCarrinho item;
	
	private List<Calcado> calcado;
	
	private List<String> caminho;
	
	private List<String> descricao;
	
	private List<String> valor;
	
	private List<String> quantidade;

	private List<String> numero;
	
	private Calcado CalcadoSelecionado;
	
	private List<String> caminhos;
	

	public ImagemController() throws Exception {
		
		this.calcado = new ArrayList<>();
		this.caminhos = new ArrayList<>();
		this.imagens =  new ArrayList<>();
		this.valor = new ArrayList<>();
		this.item = new ItemDoCarrinho();
		this.descricao = new ArrayList<>();
		this.numero = new ArrayList<>();
		adicionaLista(new Calcado(), "todos","");
	}
	
	

	public List<Calcado> getImagens() {
		return imagens;
	}








	public void setImagens(List<Calcado> imagens) {
		this.imagens = imagens;
	}








	public List<Calcado> getCalcado() {
		return calcado;
	}








	public void setCalcado(List<Calcado> calcado) {
		this.calcado = calcado;
	}








	public List<String> getCaminho() {
		return caminho;
	}








	public void setCaminho(List<String> caminho) {
		this.caminho = caminho;
	}








	public List<String> getDescricao() {
		return descricao;
	}








	public void setDescricao(List<String> descricao) {
		this.descricao = descricao;
	}








	public List<String> getValor() {
		return valor;
	}








	public void setValor(List<String> valor) {
		this.valor = valor;
	}








	public List<String> getQuantidade() {
		return quantidade;
	}








	public void setQuantidade(List<String> quantidade) {
		this.quantidade = quantidade;
	}








	public List<String> getNumero() {
		return numero;
	}








	public void setNumero(List<String> numero) {
		this.numero = numero;
	}








	public Calcado getCalcadoSelecionado() {
		return CalcadoSelecionado;
	}








	public void setCalcadoSelecionado(Calcado calcadoSelecionado) {
		CalcadoSelecionado = calcadoSelecionado;
	}








	public List<String> getCaminhos() {
		return caminhos;
	}








	public void setCaminhos(List<String> caminhos) {
		this.caminhos = caminhos;
	}








	public Calcado getCalcadoImagem() {
		
		Calcado cal = this.imagens.get(0);
		
		this.imagens.remove(0);
		
		return cal;
		
		
	}
	
	
	public void adicionaLista(Calcado calcado, String pesquisa, String parametro) throws Exception{
		
		CalcadoFacade facade = new CalcadoFacade();
		
		for (Calcado calcado2 : facade.listar(calcado, "todos", "")) {
			this.calcado.add(calcado2);
		}
	}
	
	
	
	
	
}