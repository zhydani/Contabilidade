package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Pagamento;
import repository.PagamentoRepository;

@Named
@ViewScoped
public class PagamentoOrganizacaoListing extends Listing<Pagamento> {

	private static final long serialVersionUID = 2921753168434872389L;
	
	private Double valor;
	private String filtro;
	
	public PagamentoOrganizacaoListing() {
		super(Pagamento.class);
	}
	

	public void pesquisar() {
		PagamentoRepository repo = new PagamentoRepository();
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
