package controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.EmpenhoListing;
import controller.listing.LiquidacaoListing;
import controller.listing.PagamentoListing;
import model.Empenho;
import model.Liquidacao;
import model.Pagamento;
import repository.EmpenhoRepository;

@Named
@ViewScoped
public class LiquidacaoController extends Controller<Liquidacao> {

	private static final long serialVersionUID = 5133323995601528105L;
	
	private String filtro;
	private List<Empenho> listaEmpenho;
	
	public void abrirLiquidacaoListing() {
		LiquidacaoListing listing = new LiquidacaoListing();
		listing.open();
	}
	
	public void obterLiquidacaoListing(SelectEvent event) {
		Liquidacao entity = (Liquidacao) event.getObject();
        setEntity(entity);
    	if (getEntity().getEmpenho() == null) {
			getEntity().setEmpenho(new Empenho());
    		
    	}
    	
    }
	
	@Override
	public Liquidacao getEntity() {
		if (entity == null) {
			entity = new Liquidacao();
			entity.setEmpenho(new Empenho());
			
		}
		return entity;
	}
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	

	public List<Empenho> getListaEmpenho() {
		if (listaEmpenho == null) {
			EmpenhoRepository repo = new EmpenhoRepository();
			listaEmpenho = repo.findByNumero("");
		}
		return listaEmpenho;
	}

	public void setListaCidade(List<Empenho> listaEmpenho) {
		this.listaEmpenho = listaEmpenho;
	}
	
	
	public void abrirEmpenhoListing() {
		EmpenhoListing listing = new EmpenhoListing();
		listing.open();
	}

	public void obterEmpenhoListing(SelectEvent event) {
		Empenho entity = (Empenho) event.getObject();
		getEntity().setEmpenho(entity);
	}
	
	
}
