package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.ClassificacaoOrcamentaria;
import repository.ClassificacaoOrcamentariaRepository;

@Named
@ViewScoped
public class ClassificacaoOrcamentariaListing extends Listing<ClassificacaoOrcamentaria> {

	private static final long serialVersionUID = 2921753168434872389L;
	private List<ClassificacaoOrcamentaria> list;
	private String filtro;
	
	public ClassificacaoOrcamentariaListing() {
		super(ClassificacaoOrcamentaria.class);
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
        PrimeFaces.current().dialog().openDynamic("classificacaoorcamentarialisting", options, null);
	}

	public void pesquisar() {
		ClassificacaoOrcamentariaRepository repo = new ClassificacaoOrcamentariaRepository();
		setList(repo.findByNumero(getFiltro()));
	}
	
	
	public List<ClassificacaoOrcamentaria> getList() {
		if (list == null)
			list = new ArrayList<ClassificacaoOrcamentaria>();
		return list;
	}

	public void setList(List<ClassificacaoOrcamentaria> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
