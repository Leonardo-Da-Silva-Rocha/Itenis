package br.edu.unifacear.facade;

import java.util.List;

import br.edu.unifacear.bo.MarcaBo;
import br.edu.unifacear.classes.Marca;

public class MarcaFacade {
	
	private MarcaBo marcaBo;
	
	public MarcaFacade() {
		this.marcaBo = new MarcaBo();
	}
	
	public void inserirMarca(Marca marca) throws Exception {
		this.marcaBo = new MarcaBo();
		this.marcaBo.validarMarcaSalvar(marca);
	}
	
	public void alterar(Marca marca) throws Exception {
		this.marcaBo = new MarcaBo();
		this.marcaBo.alterar(marca);
	}
	
	public void remover(Marca marca) throws Exception {
		this.marcaBo = new MarcaBo();
		this.marcaBo.remover(marca);
	}
	
	public List<Marca> listar(String pesquisa, Marca marca){
		this.marcaBo = new MarcaBo();
		return this.marcaBo.listar(pesquisa, marca);
	}
	
	
}