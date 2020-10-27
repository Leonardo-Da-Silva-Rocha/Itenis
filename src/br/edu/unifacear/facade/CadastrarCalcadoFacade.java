package br.edu.unifacear.facade;

import java.util.List;

import br.edu.unifacear.bo.CalcadoBo;
import br.edu.unifacear.bo.CategoriaBo;
import br.edu.unifacear.bo.FornecedorBo;
import br.edu.unifacear.bo.MarcaBo;
import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Categoria;
import br.edu.unifacear.classes.Fornecedor;
import br.edu.unifacear.classes.Marca;

public class CadastrarCalcadoFacade {
	
	private CalcadoBo calcadoBo;
	private CategoriaBo categoriaBo;
	private MarcaBo marcaBo;
	private FornecedorBo fornecedorBo;
	
	
	public CadastrarCalcadoFacade() {
		
		this.calcadoBo = new CalcadoBo();
		this.categoriaBo = new CategoriaBo();
		this.marcaBo = new MarcaBo();
		this.fornecedorBo = new FornecedorBo();
		
	}
	
	public List<Marca> listarMarca(Marca marca){
		
		this.marcaBo = new MarcaBo();
		return new MarcaBo().listar("marca", marca);
		
	}
	
	public List<Categoria> listarCategoria(String parametro){
		this.categoriaBo = new CategoriaBo();
		return this.categoriaBo.listar("categoria", parametro);
	}
	
	
	public List<Fornecedor> listarFornecedor(Fornecedor fornecedor){
		
		this.fornecedorBo = new FornecedorBo();
		return this.fornecedorBo.listar("fornecedor", fornecedor);
		
	}
	
	
	public void salvar(Calcado calcado) throws Exception {
		this.calcadoBo = new CalcadoBo();
		this.calcadoBo.salvarValidar("todos", calcado, "");
	}
	
	
	
	
}
