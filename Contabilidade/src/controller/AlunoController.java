package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.primefaces.event.SelectEvent;

import controller.listing.EstadoListing;
import factory.JPAFactory;
import model.Aluno;
import model.Estado;
import repository.AlunoRepository;

@Named
@ViewScoped
public class AlunoController extends Controller<Aluno> {

	private static final long serialVersionUID = 5133323995601528105L;
	
	private String filtro;
	private List<Aluno> listaAluno;
	
	public void pesquisar() {
//		EntityManager em = JPAFactory.getEntityManager();
//		Query query = em.createQuery(
//				"Select a "
//			  + "From Aluno a "
//			  + "Where upper(a.nome) like upper(:filtro)");
//		query.setParameter("filtro", "%"+ getFiltro() + "%");
//		listaAluno = query.getResultList();
		
		AlunoRepository repo = new AlunoRepository();
		listaAluno = repo.findByNome(getFiltro());
	}
	
	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();
	}
	
	public void obterEstadoListing(SelectEvent event) {
        Estado entity = (Estado) event.getObject();
        getEntity().setEstado(entity);
    }
	
	@Override
	public Aluno getEntity() {
		if (entity == null) {
			entity = new Aluno();
			entity.setEstado(new Estado());
		}
		
		return entity;
	}
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Aluno> getListaAluno() {
		if (listaAluno == null)
			listaAluno = new ArrayList<Aluno>();
		return listaAluno;
	}
	
}
