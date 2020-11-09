package br.edu.unifacear.classes;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Calcado implements EntityBase {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idCalcado;
	
	private int numero;
	private int partNumber;
	private Double valor;
	private String descricao;
	private int quantidade;
	private String codigoFornecedor;
	private String imagem;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "calcado")
	private List<ItemDoCarrinho> itemCalcado;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Marca marca;
	

	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "calcado")
	private List<ItemPedido> itemPedido;
	
	
	
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public int getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}
	public String getCodigoFornecedor() {
		return codigoFornecedor;
	}
	public void setCodigoFornecedor(String codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}
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
	
	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}
	
	public Calcado() {
		this.marca = new Marca();
		this.categoria = new Categoria();
		
		this.fornecedor = new Fornecedor();
	}
	
	
	
	
	
	public Calcado(int idCalcado, int numero, int partNumber, Double valor, String descricao, int quantidade,
			String codigoFornecedor, String imagem, List<ItemDoCarrinho> itemCalcado, Fornecedor fornecedor,
			Categoria categoria, Marca marca, List<ItemPedido> itemPedido) {
		
		this.idCalcado = idCalcado;
		this.numero = numero;
		this.partNumber = partNumber;
		this.valor = valor;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.codigoFornecedor = codigoFornecedor;
		this.imagem = imagem;
		this.itemCalcado = itemCalcado;
		this.fornecedor = fornecedor;
		this.categoria = categoria;
		this.marca = marca;
		this.itemPedido = itemPedido;
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.idCalcado;
	}
	
	
	
}
