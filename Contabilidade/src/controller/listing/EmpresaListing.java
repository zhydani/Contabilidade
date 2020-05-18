package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Empresa;
import repository.EmpresaRepository;

@Named
@ViewScoped
public class EmpresaListing extends Listing<Empresa> {

	private static final long serialVersionUID = 2921753168434872389L;
	private List<Empresa> list;
	private String filtro;
	
	public EmpresaListing() {
		super(Empresa.class);
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
        PrimeFaces.current().dialog().openDynamic("empresalisting", options, null);
	}

	public void pesquisar() {
		EmpresaRepository repo = new EmpresaRepository();
		setList(repo.findByNome(getFiltro()));
	}
	
//	public void select(int id) {
//		EntityManager em = JPAFactory.getEntityManager();
//		setEntity((Empresa) em.find(Empresa.class, id));
//		
//		// retorna o objeto via dialogreturn e finaliza o dialog
//		PrimeFaces.current().dialog().closeDynamic(getEntity());
//	}

	public List<Empresa> getList() {
		if (list == null)
			list = new ArrayList<Empresa>();
		return list;
	}

	public void setList(List<Empresa> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
