package br.edu.unifacear.facade;

import br.edu.unifacear.classes.Calcado;

public class ImagemFacade {
	
	
	private Calcado calcado;
	private String caminho;
	
	
	
	public Calcado getCalcado() {
		return calcado;
	}



	public void setCalcado(Calcado calcado) {
		this.calcado = calcado;
	}



	public String getCaminho() {
		return caminho;
	}



	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}



	public void ImagemFacade() {
		this.calcado = new Calcado();
	}
	
	
	
}
