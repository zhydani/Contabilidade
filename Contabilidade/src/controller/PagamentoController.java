package controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.LiquidacaoListing;
import model.Liquidacao;
import model.Pagamento;
import repository.LiquidacaoRepository;

@Named
@ViewScoped
public class PagamentoController extends Controller<Pagamento> {

	private static final long serialVersionUID = 5133323995601528105L;
	
	private String filtro;
	private List<Liquidacao> listaLiquidacao;
	
	
	@Override
	public Pagamento getEntity() {
		if (entity == null) {
			entity = new Pagamento();
			entity.setLiquidacao(new Liquidacao());
			
		}
		return entity;
	}
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	

	public List<Liquidacao> getListaLiquidacao() {
		if (listaLiquidacao == null) {
			LiquidacaoRepository repo = new LiquidacaoRepository();
			listaLiquidacao = repo.findByNumero("");
		}
		return listaLiquidacao;
	}

	public void setListaCidade(List<Liquidacao> listaLiquidacao) {
		this.listaLiquidacao = listaLiquidacao;
	}
	
	
	public void abrirLiquidacaoListing() {
		LiquidacaoListing listing = new LiquidacaoListing();
		listing.open();
	}

	public void obterLiquidacaoListing(SelectEvent event) {
		Liquidacao entity = (Liquidacao) event.getObject();
		getEntity().setLiquidacao(entity);
	}
	
	
}
