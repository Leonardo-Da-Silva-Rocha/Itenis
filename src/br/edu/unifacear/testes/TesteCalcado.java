package br.edu.unifacear.testes;

import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Categoria;
import br.edu.unifacear.classes.Fornecedor;
import br.edu.unifacear.classes.Marca;
import br.edu.unifacear.controller.CalcadoController;

public class TesteCalcado {

	public static void main(String[] args) {
		
		Calcado calcado = new Calcado();
		Marca marca = new Marca();
		Categoria categoria = new Categoria();
		Fornecedor fornecedor = new Fornecedor();
		
		marca.setIdMarca(1);
		categoria.setIdCategoria(2);
		fornecedor.setIdFornecedor(1);
		
		calcado.setDescricao("testado");
		calcado.setMarca(marca);
		calcado.setCategoria(categoria);
		calcado.setFornecedor(fornecedor);
		calcado.setQuantidade(3);
		calcado.setNumero(38);
		calcado.setValor(290.00);
		
		CalcadoController ct = new CalcadoController();
		ct.setCalcado(calcado);
		ct.salvar(calcado, "todos", "");
	

	}
	
	

}
