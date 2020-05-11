package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.PrimeFaces;

import factory.JPAFactory;
import model.Estado;
import repository.EstadoRepository;

@Named
@ViewScoped
public class EstadoListing extends Listing<Estado> {

	private static final long serialVersionUID = 2921753168434872389L;
	private List<Estado> list;
	private String filtro;
	
	@Override
	public Estado getEntity() {
		if (entity == null)
			entity = new Estado();
		return entity;
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
        PrimeFaces.current().dialog().openDynamic("estadolisting", options, null);
	}

	public void pesquisar() {
		EstadoRepository repo = new EstadoRepository();
		setList(repo.findByNome(getFiltro()));
	}
	
	public void select(int id) {
		EntityManager em = JPAFactory.getEntityManager();
		setEntity((Estado) em.find(Estado.class, id));
		
		// retorna o objeto via dialogreturn e finaliza o dialog
		PrimeFaces.current().dialog().closeDynamic(getEntity());
	}
	
	public List<Estado> getList() {
		if (list == null)
			list = new ArrayList<Estado>();
		return list;
	}

	public void setList(List<Estado> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
