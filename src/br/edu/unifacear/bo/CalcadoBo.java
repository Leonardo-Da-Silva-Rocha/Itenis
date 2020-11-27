package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Calcado;

import br.edu.unifacear.dao.CalcadoDao;
import br.edu.unifacear.dao.GenericDao;

public class CalcadoBo {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void salvarValidar(String pesquisa, Calcado calcado, String parametro2) throws Exception {

		List<Calcado> lista = new CalcadoDao().listar(pesquisa, calcado, parametro2);

		for (Calcado calcado2 : lista) {

			if (calcado2.getDescricao().toUpperCase().equals(calcado.getDescricao().toUpperCase())) {

				if (calcado2.getNumero() == calcado.getNumero()) {// valida o tamanho do cal�ado

					throw new Exception("N�o foi poss�vel cadastrar, tamanho ja cadastrado");

				}

				if (calcado2.getPartNumber() == calcado.getPartNumber()) {
					throw new Exception("N�o foi poss�vel cadastrar, PartNumber j� cadastrado");
				} else if (calcado.getPartNumber() <= 0) {
					throw new Exception("N�o foi poss�vel cadastrar, PartNumber invalido");
				}

			}
		}

		validar(calcado);

		new GenericDao().saveOrUpdate(calcado);

	}

	public List<Calcado> listar(String pesquisa, Calcado parametro, String parametro2) throws Exception {
		try {
			return new CalcadoDao().listar(pesquisa, parametro, parametro2);
		} catch (Exception e) {
			throw new Exception("Erro ao listar o calcado");
		}
	}

	public void alterar(Calcado calcado) throws Exception {

		try {

			validar(calcado);
			new GenericDao().saveOrUpdate(calcado);
		} catch (Exception e) {
			throw new Exception("Erro ao alterar o calcado");
		}

	}

	public void validar(Calcado calcado) throws Exception {
		if (calcado.getCodigoFornecedor().equals(calcado.getFornecedor().getCodigo()) == false) { // valida o codigo da
																									// // empresa
			throw new Exception("N�o foi poss�vel cadastrar, Codigo da empresa fornecedora invalido");
		} else if (calcado.getNumero() < 32 || calcado.getNumero() > 42) {// valida o numero do ca�ado
			throw new Exception("N�o foi poss�vel cadastrar, Numero do cal�ado invalido");
		} else if (calcado.getQuantidade() <= 0) {// valida a quantidade daquele cal�ado
			throw new Exception("N�o foi poss�vel cadastrar, quantidade de cal�ado invalida");
		} else if (calcado.getValor() <= 0) {
			throw new Exception("N�o foi poss�vel cadastrar, Valor invalido");
		} else if (calcado.getImagem().equals("") == true) {
			throw new Exception("N�o foi poss�vel cadastrar, selecione uma imagem");
		}
	}

	public void excluir(Calcado calcado) throws Exception {
		try {

			new GenericDao().remove(calcado.getClass(), calcado.getId());
		} catch (Exception e) {
			throw new Exception("Erro ao alterar o calcado");
		}

	}

}