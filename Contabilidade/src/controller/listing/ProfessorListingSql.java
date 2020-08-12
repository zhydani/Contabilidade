package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Professor;
import repository.ProfessorRepository;

@Named
@ViewScoped
public class ProfessorListingSql extends Listing<Professor> {

	private static final long serialVersionUID = 2921753168434872389L;
	private List<Object[]> list;
	private String filtro;

	public ProfessorListingSql() {
		super(Professor.class);
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
        PrimeFaces.current().dialog().openDynamic("professorlistingsql", options, null);
	}

	public void pesquisar() {
		ProfessorRepository repo = new ProfessorRepository();
		setList(repo.findByNomeSql(getFiltro()));
	}
	

	public List<Object[]> getList() {
		if (list == null)
			list = new ArrayList<Object[]>();
		return list;
	}

	public void setList(List<Object[]> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
