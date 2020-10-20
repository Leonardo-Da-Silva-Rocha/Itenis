package br.edu.unifacear.classes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Endereco implements EntityBase {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	
	private int numero;
	private String logradouro;
	private String complemento;
	private String estado;
	private String cidade;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "endereco")
	private List<Pedido> pedido;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "endereco")
	private List<Cliente> cliente;

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	public Endereco() {
		
	}

	public Endereco(int id, int numero, String logradouro, String complemento, String estado, String cidade,
			List<Pedido> pedido, List<Cliente> cliente) {
		
		this.id = id;
		this.numero = numero;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.estado = estado;
		this.cidade = cidade;
		this.pedido = pedido;
		this.cliente = cliente;
	}
	
}
