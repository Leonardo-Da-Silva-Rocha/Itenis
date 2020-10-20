package br.edu.unifacear.classes;

import java.util.List;

import javax.persistence.*;
@Entity
public class Administrador implements EntityBase {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idAdministrador;
	
	private String nome;
	private String senha;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "administrador")
	private List<Vendedor> vendedor;
	
	

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
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

	public List<Vendedor> getVendedor() {
		return vendedor;
	}

	public void setVendedor(List<Vendedor> vendedor) {
		this.vendedor = vendedor;
	}

	public Administrador() {
		
	}

	

	public Administrador(int idAdministrador, String nome, String senha, List<Vendedor> vendedor) {
		
		this.idAdministrador = idAdministrador;
		this.nome = nome;
		this.senha = senha;
		this.vendedor = vendedor;
	}

	@Override
	public String toString() {
		return "Administrador [nome=" + nome + ", senha=" + senha + ", vendedor=" + vendedor + "]";
	}

	@Override
	public int getId() {
		
		return this.idAdministrador;
	}

	
	
	
}
