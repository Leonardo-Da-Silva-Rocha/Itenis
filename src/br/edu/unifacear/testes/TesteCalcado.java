package br.edu.unifacear.testes;

import br.edu.unifacear.bo.CalcadoBo;
import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.classes.Categoria;
import br.edu.unifacear.classes.Fornecedor;
import br.edu.unifacear.classes.Marca;
import br.edu.unifacear.dao.GenericDao;

public class TesteCalcado {

	public static void main(String[] args) {
		
		Calcado calcado = new Calcado();
		Marca marca = new Marca();
		Categoria categoria = new Categoria();
		Fornecedor fornecedor = new Fornecedor();
		
		marca.setIdMarca(1);
		categoria.setIdCategoria(1);
		fornecedor.setIdFornecedor(1);
		
		calcado.setDescricao("Nike");
		calcado.setMarca(marca);
		calcado.setCategoria(categoria);
		calcado.setFornecedor(fornecedor);
		calcado.setQuantidade(3);
		calcado.setNumero(38);
		calcado.setValor(290.00);
		
		try { //adicionar
			new CalcadoBo().salvarValidar("todos", calcado);
			System.out.println("calcado adicionado");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {//Listar
			
			for (Calcado cal : new CalcadoBo().listar("todos", calcado)) {
				System.out.println("Nome = "+cal.getDescricao()+" valor = "+cal.getValor()+" quantidade = "+cal.getQuantidade());
			}
			
		}catch(Exception e) {
			System.out.println("Erro ao listar");
		}
		
		System.out.println();
		
		calcado.setQuantidade(1);
		
		try { //Alterar
			
			new GenericDao().saveOrUpdate(calcado);
			System.out.println("calcado alterado");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {//Listar
			
			for (Calcado cal : new CalcadoBo().listar("todos", calcado)) {
				System.out.println("Nome = "+cal.getDescricao()+" valor = "+cal.getValor()+" quantidade = "+cal.getQuantidade());
			}
			
		}catch(Exception e) {
			System.out.println("Erro ao listar");
		}
		
		try { //Remover
			
			new GenericDao().remove(calcado.getClass(), calcado.getId());
			System.out.println("calcado removido");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {//Listar
			
			for (Calcado cal : new CalcadoBo().listar("todos", calcado)) {
				System.out.println("Nome = "+cal.getDescricao()+" valor = "+cal.getValor()+" quantidade = "+cal.getQuantidade());
			}
			
		}catch(Exception e) {
			System.out.println("Erro ao listar");
		}

	}
	
	

}
