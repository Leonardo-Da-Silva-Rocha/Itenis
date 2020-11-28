package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.classes.Administrador;
import br.edu.unifacear.classes.Vendedor;
import br.edu.unifacear.facade.VendedorFacade;

@ManagedBean(name = "vendedorBean")
@SessionScoped
public class VendedorController {

	private Vendedor vendedor;
	private Administrador adm;
	
	
	public Administrador getAdm() {
		return adm;
	}

	public void setAdm(Administrador adm) {
		this.adm = adm;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public VendedorController() {
		this.adm = new Administrador();
		this.vendedor = new Vendedor();

	}

	public void salvar() {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			VendedorFacade facade = new VendedorFacade();
			this.adm.setIdAdministrador(1);
			this.vendedor.setAdministrador(adm);
			facade.inserirVendedor(vendedor);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vendedor Salvo com sucesso", ""));

		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

	}

}
