package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Empenho;
import model.Organizacao;
import repository.EmpenhoRepository;
import repository.OrganizacaoRepository;

@Named
@ViewScoped
public class EmpenhoOrganizacaoListing extends Listing<Empenho> {

	private static final long serialVersionUID = 2921753168434872389L;
	
	private Double valor;
	private String filtro;
	
	public EmpenhoOrganizacaoListing() {
		super(Empenho.class);
	}
	

	public void pesquisar() {
		EmpenhoRepository repo = new EmpenhoRepository();
		setValor(repo.findByOrganizacao(getFiltro()));
	}
	
	public List<Organizacao> completeTheme(String query) {
		OrganizacaoRepository repo = new OrganizacaoRepository();
		if (repo.findAll() != null) {
			String queryLowerCase = query.toLowerCase();
			List<Organizacao> orgs = repo.findAll();
			return orgs.stream().filter(t -> t.getNome().toLowerCase().startsWith(queryLowerCase))
					.collect(Collectors.toList());
		}
		return null;
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
