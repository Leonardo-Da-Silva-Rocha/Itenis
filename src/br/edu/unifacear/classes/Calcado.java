package br.edu.unifacear.classes;

import java.util.List;

import javax.persistence.*;

@Entity
public class Calcado implements EntityBase {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idCalcado;
	
	private int numero;
	private String cor;
	private Double valor;
	private String descricao;
	private int quantidade;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "calcado")
	private List<ItemDoCarrinho> itemCalcado;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Marca marca;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "calcado")
	private List<CalcadoFoto> calcadoFoto;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "calcado")
	private List<ItemPedido> itemPedido;
	
	

	public void setIdCalcado(int idCalcado) {
		this.idCalcado = idCalcado;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<ItemDoCarrinho> getItemCalcado() {
		return itemCalcado;
	}
	public void setItemCalcado(List<ItemDoCarrinho> itemCalcado) {
		this.itemCalcado = itemCalcado;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public List<CalcadoFoto> getCalcadoFoto() {
		return calcadoFoto;
	}
	public void setCalcadoFoto(List<CalcadoFoto> calcadoFoto) {
		this.calcadoFoto = calcadoFoto;
	}
	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}
	
	public Calcado() {
		
	}
	
	public Calcado(int idCalcado, int numero, String cor, Double valor, String descricao, int quantidade,
			List<ItemDoCarrinho> itemCalcado, Fornecedor fornecedor, Categoria categoria, Marca marca,
			List<CalcadoFoto> calcadoFoto, List<ItemPedido> itemPedido) {
		
		this.idCalcado = idCalcado;
		this.numero = numero;
		this.cor = cor;
		this.valor = valor;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.itemCalcado = itemCalcado;
		this.fornecedor = fornecedor;
		this.categoria = categoria;
		this.marca = marca;
		this.calcadoFoto = calcadoFoto;
		this.itemPedido = itemPedido;
	}
	@Override
	public String toString() {
		return "Calcado [numero=" + numero + ", cor=" + cor + ", valor=" + valor + ", descricao=" + descricao
				+ ", itemCalcado=" + itemCalcado + ", fornecedor=" + fornecedor + ", categoria=" + categoria
				+ ", marca=" + marca + ", calcadoFoto=" + calcadoFoto + ", itemPedido=" + itemPedido + "]";
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.idCalcado;
	}
	
	
	
}
