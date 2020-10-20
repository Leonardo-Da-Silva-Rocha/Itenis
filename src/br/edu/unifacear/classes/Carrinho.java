package br.edu.unifacear.classes;



import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
public class Carrinho implements EntityBase {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idCarrinho;
	
	private Date dataAdd;
	
	@OneToOne
	private Cliente cliente;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "carrinho")
	private List<ItemDoCarrinho> itemCalcado;


	public void setIdCarrinho(int id) {
		this.idCarrinho = id;
	}
	
	public Date getDataAdd() {
		return dataAdd;
	}


	public void setDataAdd(Date dataAdd) {
		this.dataAdd = dataAdd;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<ItemDoCarrinho> getItem() {
		return itemCalcado;
	}


	public void setItem(List<ItemDoCarrinho> item) {
		this.itemCalcado = item;
	}


	public Carrinho() {
		this.cliente = new Cliente();
	}


	public Carrinho(Date dataAdd, Cliente cliente, List<ItemDoCarrinho> item) {
		
		this.dataAdd = dataAdd;
		this.cliente = cliente;
		this.itemCalcado = item;
	}


	@Override
	public String toString() {
		return "Carrinho [dataAdd=" + dataAdd + ", cliente=" + cliente + ", item=" + itemCalcado + "]";
	}


	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.idCarrinho;
	}
	
	
	
	
}
