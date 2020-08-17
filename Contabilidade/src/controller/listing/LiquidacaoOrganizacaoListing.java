package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Liquidacao;
import repository.LiquidacaoRepository;

@Named
@ViewScoped
public class LiquidacaoOrganizacaoListing extends Listing<Liquidacao> {

	private static final long serialVersionUID = 2921753168434872389L;
	
	private Double valor;
	private String filtro;
	
	public LiquidacaoOrganizacaoListing() {
		super(Liquidacao.class);
	}
	

	public void pesquisar() {
		LiquidacaoRepository repo = new LiquidacaoRepository();
		setValor(repo.findByOrganizacao(getFiltro()));
	}
	
	
	

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}

}
