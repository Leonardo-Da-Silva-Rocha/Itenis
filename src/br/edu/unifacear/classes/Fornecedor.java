package br.edu.unifacear.classes;

import java.util.List;

import javax.persistence.*;

@Entity
public class Fornecedor implements EntityBase {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idFornecedor;
	
	
	private String descricao;
	private String endereco;
	private String telefone;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "fornecedor")
	private List<Calcado> calcado;


	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Calcado> getCalcado() {
		return calcado;
	}

	public void setCalcado(List<Calcado> calcado) {
		this.calcado = calcado;
	}

	public Fornecedor() {
		
	}

	public Fornecedor(String descricao, String endereco, String telefone, List<Calcado> calcado) {
		
		this.descricao = descricao;
		this.endereco = endereco;
		this.telefone = telefone;
		this.calcado = calcado;
	}

	@Override
	public String toString() {
		return "Fornecedor [descricao=" + descricao + ", endereco=" + endereco + ", telefone=" + telefone + ", calcado="
				+ calcado + "]";
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.idFornecedor;
	}
	
	
}
