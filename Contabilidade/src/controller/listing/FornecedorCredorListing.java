package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.FornecedorCredor;
import repository.FornecedorCredorRepository;

@Named
@ViewScoped
public class FornecedorCredorListing extends Listing<FornecedorCredor> {

	private static final long serialVersionUID = 2921753168434872389L;
	private List<FornecedorCredor> list;
	private String filtro;
	
	public FornecedorCredorListing() {
		super(FornecedorCredor.class);
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
        PrimeFaces.current().dialog().openDynamic("fornecedorcredorlisting", options, null);
	}

	public void pesquisar() {
		FornecedorCredorRepository repo = new FornecedorCredorRepository();
		setList(repo.findByNome(getFiltro()));
	}
	
	
	public List<FornecedorCredor> getList() {
		if (list == null)
			list = new ArrayList<FornecedorCredor>();
		return list;
	}

	public void setList(List<FornecedorCredor> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
