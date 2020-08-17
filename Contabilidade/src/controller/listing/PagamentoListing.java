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
public class PagamentoListing extends Listing<Pagamento> {

	private static final long serialVersionUID = 2921753168434872389L;
	
	private List<Pagamento> list;
	private String filtro;
	
	public PagamentoListing() {
		super(Pagamento.class);
	}
	
	public void open() {
		
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 800);
        options.put("height", 500);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");  
        // ligacao com a pagina xhtml
        PrimeFaces.current().dialog().openDynamic("pagamentolisting", options, null);
	}

	public void pesquisar() {
		PagamentoRepository repo = new PagamentoRepository();
		setList(repo.findByNumero(getFiltro()));
	}
	
	
	public List<Pagamento> getList() {
		if (list == null)
			list = new ArrayList<Pagamento>();
		return list;
	}

	public void setList(List<Pagamento> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
