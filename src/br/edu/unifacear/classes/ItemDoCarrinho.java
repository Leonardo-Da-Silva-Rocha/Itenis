package br.edu.unifacear.classes;



import javax.persistence.*;

@Entity
public class ItemDoCarrinho implements EntityBase{
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idItemDoCarrinho;
	
	private int quantidade;
	private Double valor;
	
	@ManyToOne
	private Calcado calcado;
	
	@ManyToOne
	private Carrinho carrinho;
	
	public void setId(int id) {
		this.idItemDoCarrinho = id;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Calcado getCalcado() {
		return calcado;
	}
	public void setCalcado(Calcado calcado) {
		this.calcado = calcado;
	}
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	
	public ItemDoCarrinho() {
		
		this.calcado = new Calcado();
		this.carrinho = new Carrinho();
		
	}
	public ItemDoCarrinho(int quantidade, Double valor, Calcado calcado, Carrinho carrinho) {
		
		this.quantidade = quantidade;
		this.valor = valor;
		this.calcado = calcado;
		this.carrinho = carrinho;
	}
	
	@Override
	public String toString() {
		return "ItemDoCarrinho [quantidade=" + quantidade + ", valor=" + valor + ", calcado=" + calcado + ", carrinho="
				+ carrinho + "]";
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.idItemDoCarrinho;
	}
	
	
	
}
