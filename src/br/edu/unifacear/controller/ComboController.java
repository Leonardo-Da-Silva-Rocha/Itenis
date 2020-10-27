package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean(name="comboBean")
@RequestScoped
public class ComboController {
	
	private List<String> Estados;
	
	public ComboController() {
		this.Estados = new ArrayList<>();
		carregarEstados();
	}

	public List<String> getEstados() {
		return Estados;
	}

	public void setEstados(List<String> estados) {
		Estados = estados;
	}
	
	public void carregarEstados() {
		
		this.Estados.add("AP");
		this.Estados.add("AM");
		this.Estados.add("BA");
		this.Estados.add("CE");
		this.Estados.add("ES");
		this.Estados.add("GO"); 
		this.Estados.add("MA"); 
		this.Estados.add("MT"); 
		this.Estados.add("MS");
		this.Estados.add("MG");
		this.Estados.add("PA");
		this.Estados.add("PB"); 
		this.Estados.add("PR"); 
		this.Estados.add("PE");
		this.Estados.add("PI");
		this.Estados.add("RJ");
		this.Estados.add("RN");
		this.Estados.add("RS");
		this.Estados.add("RO");
		this.Estados.add("RR");
		this.Estados.add("SC");
		this.Estados.add("SP");
		this.Estados.add("SE");
		this.Estados.add("TO");
		this.Estados.add("DF");
       
     
	}
	
}
