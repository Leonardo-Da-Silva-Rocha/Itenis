package br.edu.unifacear.classes;

import java.util.List;

import javax.persistence.*;

@Entity
public class Marca implements EntityBase {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idMarca;
	
	private String descricao;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "marca")
	private List<Calcado> calcado;
	
	
	public int getIdMarca() {
		return this.idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Calcado> getCalcado() {
		return calcado;
	}
	public void setCalcado(List<Calcado> calcado) {
		this.calcado = calcado;
	}
	
	public Marca() {
		
	}
	
	public Marca(int idMarca, String descricao, List<Calcado> calcado) {
		
		this.idMarca = idMarca;
		this.descricao = descricao;
		this.calcado = calcado;
	}
	
	
	@Override
	public int getId() {
		return this.idMarca;
	}
	
	
	
	
	
}
