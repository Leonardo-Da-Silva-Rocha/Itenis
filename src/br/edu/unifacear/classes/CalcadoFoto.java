package br.edu.unifacear.classes;

import javax.persistence.*;

@Entity
public class CalcadoFoto {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idCalcadoFoto;
	
	private String numerExterno;
	
	
	@ManyToOne
	private Calcado calcado;

	public String getNumerExterno() {
		return numerExterno;
	}

	public void setNumerExterno(String numerExterno) {
		this.numerExterno = numerExterno;
	}

	public Calcado getCalcado() {
		return calcado;
	}

	public void setCalcado(Calcado calcado) {
		this.calcado = calcado;
	}

	public CalcadoFoto() {
		
	}

	public CalcadoFoto(String numerExterno, Calcado calcado) {
		
		this.numerExterno = numerExterno;
		this.calcado = calcado;
	}

	
	
	
	
	
	
}
