package br.edu.unifacear.facade;



import br.edu.unifacear.bo.VendedorBo;
import br.edu.unifacear.classes.Vendedor;

public class VendedorFacade {
	
	private VendedorBo vendedorBo;
	
	
	public VendedorFacade() {
		this.vendedorBo = new VendedorBo();
		
	}
	
	
	public void inserirVendedor(Vendedor vendedor) throws Exception {
		this.vendedorBo = new VendedorBo();
		this.vendedorBo.salvar(vendedor);
	}
	
}
