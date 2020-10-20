package br.edu.unifacear.classes;

import java.util.List;

import javax.persistence.*;

@Entity
public class Vendedor implements EntityBase {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Id
	private int idVendedor;
	
	private String nome;
	private String senha;
	private String email;
	private String cnpj;
	private String nomeLoja;
	private String enderecoLoja;
	private String telefone;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy = "vendedor")
	private Comissao comissao;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "vendedor")
	private List<Pedido> pedido;
	
	@ManyToOne
	private Administrador administrador;
	
	
	
	public int getIdVendedor() {
		return idVendedor;
	}



	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCnpj() {
		return cnpj;
	}



	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}



	public String getNomeLoja() {
		return nomeLoja;
	}



	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}



	public String getEnderecoLoja() {
		return enderecoLoja;
	}



	public void setEnderecoLoja(String enderecoLoja) {
		this.enderecoLoja = enderecoLoja;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public Comissao getComissao() {
		return comissao;
	}



	public void setComissao(Comissao comissao) {
		this.comissao = comissao;
	}



	public List<Pedido> getPedido() {
		return pedido;
	}



	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}



	public Administrador getAdministrador() {
		return administrador;
	}



	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	

	public Vendedor() {
		
	}

	

	public Vendedor(int idVendedor, String nome, String senha, String email, String cnpj, String nomeLoja,
			String enderecoLoja, String telefone, Comissao comissao, List<Pedido> pedido, Administrador administrador) {
		
		this.idVendedor = idVendedor;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.cnpj = cnpj;
		this.nomeLoja = nomeLoja;
		this.enderecoLoja = enderecoLoja;
		this.telefone = telefone;
		this.comissao = comissao;
		this.pedido = pedido;
		this.administrador = administrador;
	}



	@Override
	public int getId() {
		
		return this.idVendedor;
	}
	
	
	
}
