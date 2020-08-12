package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Aluno;
import repository.AlunoRepository;

@Named
@ViewScoped
public class AlunoListing extends Listing<Aluno> {

	private static final long serialVersionUID = 2921753168434872389L;
	private List<Aluno> list;
	private String filtro;
	

	public AlunoListing() {
		super(Aluno.class);
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
        PrimeFaces.current().dialog().openDynamic("alunolisting", options, null);
	}

	public void pesquisar() {
		AlunoRepository repo = new AlunoRepository();
		setList(repo.findByNome(getFiltro()));
	}
	

	public List<Aluno> getList() {
		if (list == null)
			list = new ArrayList<Aluno>();
		return list;
	}

	public void setList(List<Aluno> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
