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
	private String confirmarSenha;
	private String email;
	private String cpf;
	
	
	private String telefone;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy = "vendedor")
	private Comissao comissao;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "vendedor")
	private List<Pedido> pedido;
	
	@ManyToOne
	private Administrador administrador;
	
	
	
	
	
	public String getConfirmarSenha() {
		return confirmarSenha;
	}



	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



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
		return cpf;
	}



	public void setCnpj(String cnpj) {
		this.cpf = cnpj;
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

	


	



	public Vendedor(int idVendedor, String nome, String senha, String confirmarSenha, String email, String cpf,
			String telefone, Comissao comissao, List<Pedido> pedido, Administrador administrador) {
	
		this.idVendedor = idVendedor;
		this.nome = nome;
		this.senha = senha;
		this.confirmarSenha = confirmarSenha;
		this.email = email;
		this.cpf = cpf;
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
