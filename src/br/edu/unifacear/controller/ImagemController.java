package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.ItemDoCarrinho;
import br.edu.unifacear.facade.CalcadoFacade;
import net.bytebuddy.asm.Advice.This;

@ManagedBean(name = "imagemBean")
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

	private String pesquisa;

	public ImagemController() throws Exception {

		this.calcado = new ArrayList<>();
		this.caminhos = new ArrayList<>();
		this.imagens = new ArrayList<>();
		this.valor = new ArrayList<>();
		this.item = new ItemDoCarrinho();
		this.descricao = new ArrayList<>();
		this.numero = new ArrayList<>();
		this.pesquisa = "";
		adicionaLista(new Calcado(), "todos", "");
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
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

	public void adicionaLista(Calcado calcado, String pesquisa, String parametro) throws Exception {

		CalcadoFacade facade = new CalcadoFacade();

		for (Calcado calcado2 : facade.listar(calcado, "todos", "")) {
			this.calcado.add(calcado2);
		}
	}

	public void pesquisar() {

		List<Calcado> calcados = new ArrayList<>();

		for (Calcado calcado2 : calcado) {

			if (calcado2.getCategoria().getDescricao().toUpperCase().equals(pesquisa.toUpperCase())) {

				calcados.add(calcado2);
			} else if (calcado2.getMarca().getDescricao().toUpperCase().equals(pesquisa.toUpperCase())) {
				calcados.add(calcado2);
			} else if (calcado2.getDescricao().toUpperCase().equals(pesquisa.toUpperCase())) {
				calcados.add(calcado2);
			}

		}

		this.calcado = calcados;

	}

	public void pesquisarMasculino() {

		List<Calcado> calcados = new ArrayList<>();

		for (Calcado calcado2 : calcado) {

			if (calcado2.getGenero().equals("Masculino")) {
				calcados.add(calcado2);
			}

		}

		this.calcado = calcados;

	}

	public void pesquisarFeminino() {

		List<Calcado> calcados = new ArrayList<>();

		for (Calcado calcado2 : calcado) {

			if (calcado2.getGenero().equals("Feminino")) {
				calcados.add(calcado2);
			}

		}

		this.calcado = calcados;

	}

	public void pesquisarInfantil() {

		List<Calcado> calcados = new ArrayList<>();

		for (Calcado calcado2 : calcado) {

			if (calcado2.getGenero().equals("Infantil")) {
				calcados.add(calcado2);
			}

		}

		this.calcado = calcados;

	}

	public void alterar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			CalcadoFacade facade = new CalcadoFacade();

			facade.alterar(this.CalcadoSelecionado);

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Calçado alterado com sucesso", ""));

		} catch (Exception e) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao alterar", "Verifique confira os campos"));
		}
	}

	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			CalcadoFacade facade = new CalcadoFacade();
			this.calcado.remove(this.CalcadoSelecionado);
			facade.excluir(this.CalcadoSelecionado);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Calçado alterado com sucesso", ""));

		} catch (Exception e) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao alterar", "Verifique confira os campos"));
		}
	}

}