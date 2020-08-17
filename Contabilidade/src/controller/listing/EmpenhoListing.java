package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Empenho;
import repository.EmpenhoRepository;

@Named
@ViewScoped
public class EmpenhoListing extends Listing<Empenho> {

	private static final long serialVersionUID = 2921753168434872389L;
	
	private List<Empenho> list;
	private String filtro;
	
	public EmpenhoListing() {
		super(Empenho.class);
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
        PrimeFaces.current().dialog().openDynamic("empenholisting", options, null);
	}

	public void pesquisar() {
		EmpenhoRepository repo = new EmpenhoRepository();
		setList(repo.findByNumero(getFiltro()));
	}
	
	
	public List<Empenho> getList() {
		if (list == null)
			list = new ArrayList<Empenho>();
		return list;
	}

	public void setList(List<Empenho> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
