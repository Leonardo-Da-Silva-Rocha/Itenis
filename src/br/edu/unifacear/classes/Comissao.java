package br.edu.unifacear.classes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Comissao implements EntityBase{
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idComissao;
	
	private Double dinheiro;
	private Double porcentagem;
	private Date dataPagamento;
	
	@OneToOne
	private Vendedor vendedor;

	

	public int getIdComissao() {
		return idComissao;
	}



	public void setIdComissao(int idComissao) {
		this.idComissao = idComissao;
	}



	public Double getDinheiro() {
		return dinheiro;
	}



	public void setDinheiro(Double dinheiro) {
		this.dinheiro = dinheiro;
	}



	public Double getPorcentagem() {
		return porcentagem;
	}



	public void setPorcentagem(Double porcentagem) {
		this.porcentagem = porcentagem;
	}



	public Date getDataPagamento() {
		return dataPagamento;
	}



	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}



	public Vendedor getVendedor() {
		return vendedor;
	}



	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	
	public Comissao() {
		
	}


	public Comissao(int idComissao, Double dinheiro, Double porcentagem, Date dataPagamento, Vendedor vendedor) {
		
		this.idComissao = idComissao;
		this.dinheiro = dinheiro;
		this.porcentagem = porcentagem;
		this.dataPagamento = dataPagamento;
		this.vendedor = vendedor;
	}



	@Override
	public String toString() {
		return "Comissao [idComissao=" + idComissao + ", dinheiro=" + dinheiro + ", porcentagem=" + porcentagem
				+ ", dataPagamento=" + dataPagamento + ", vendedor=" + vendedor + "]";
	}



	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.getId();
	}
	
}
