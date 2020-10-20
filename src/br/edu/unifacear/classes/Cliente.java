package br.edu.unifacear.classes;

import java.util.Date;
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
public class Cliente implements EntityBase{
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idCliente;
	
	private String nome;
	private String cpf;
	private Date DataNacimento ;
	private String email;
	private String senha;
	private String telefone;
	
	@ManyToOne
	private Endereco endereco;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy = "cliente")
	private Carrinho carrinho;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "cliente")
	private List<Pedido> pedido;
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNacimento() {
		return DataNacimento;
	}
	public void setDataNacimento(Date dataNacimento) {
		DataNacimento = dataNacimento;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	public List<Pedido> getPedido() {
		return pedido;
	}
	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	
	
	public Cliente() {
		
	}
	
	
	
	
	
	public Cliente(int idCliente, String nome, String cpf, Date dataNacimento, String email, String senha,
			String telefone, Endereco endereco, Carrinho carrinho, List<Pedido> pedido) {
		
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		DataNacimento = dataNacimento;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.endereco = endereco;
		this.carrinho = carrinho;
		this.pedido = pedido;
	}

	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", DataNacimento="
				+ DataNacimento + ", email=" + email + ", senha=" + senha + ", telefone=" + telefone + ", endereco="
				+ endereco + ", carrinho=" + carrinho + ", pedido=" + pedido + "]";
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.idCliente;
	}
		
}
