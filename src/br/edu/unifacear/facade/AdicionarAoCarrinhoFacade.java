package br.edu.unifacear.facade;


import java.util.List;

import br.edu.unifacear.bo.CalcadoBo;
import br.edu.unifacear.bo.CarrinhoBo;
import br.edu.unifacear.bo.ItemDoCarrinhoBo;
import br.edu.unifacear.classes.Calcado;

public class AdicionarAoCarrinhoFacade {
		
	private CalcadoBo calcadoBo;
	private CarrinhoBo carrinhoBo;
	private ItemDoCarrinhoBo itemBo;
	
	
	public AdicionarAoCarrinhoFacade() {
		this.calcadoBo = new CalcadoBo();
		this.carrinhoBo = new CarrinhoBo();
		this.itemBo = new ItemDoCarrinhoBo();
	}
	
	
	public List<Calcado> listarCalcado(Calcado calcado) throws Exception{
		return this.calcadoBo.listar("adicionar", calcado, calcado.getImagem());
	}
	
}
