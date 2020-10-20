package br.edu.unifacear.classes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Categoria implements EntityBase {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idCategoria;
	
	private String descricao;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "categoria")
	private List<Calcado> calcado;
	
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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
	
	public Categoria() {
		
	}
	public Categoria(String descricao, List<Calcado> calcado) {
		
		this.descricao = descricao;
		this.calcado = calcado;
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.idCategoria;
	}
	
	
	
}
