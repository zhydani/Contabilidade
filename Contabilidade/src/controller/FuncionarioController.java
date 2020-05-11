package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.primefaces.event.SelectEvent;

//import controller.listing.EstadoListing;
import factory.JPAFactory;
import model.Funcionario;
//import model.Estado;
import repository.FuncionarioRepository;

@Named
@ViewScoped
public class FuncionarioController extends Controller<Funcionario> {

	private static final long serialVersionUID = 5133323995601528105L;
	
	private String filtro;
	private List<Funcionario> listaFuncionario;
	
	public void pesquisar() {
//		EntityManager em = JPAFactory.getEntityManager();
//		Query query = em.createQuery(
//				"Select a "
//			  + "From Funcionario a "
//			  + "Where upper(a.nome) like upper(:filtro)");
//		query.setParameter("filtro", "%"+ getFiltro() + "%");
//		listaFuncionario = query.getResultList();
		
		FuncionarioRepository repo = new FuncionarioRepository();
		listaFuncionario = repo.findByNome(getFiltro());
	}
	
//	public void abrirEstadoListing() {
//		EstadoListing listing = new EstadoListing();
//		listing.open();
//	}
//	
//	public void obterEstadoListing(SelectEvent event) {
//        Estado entity = (Estado) event.getObject();
//        getEntity().setEstado(entity);
//    }
//	
//	@Override
//	public Funcionario getEntity() {
//		if (entity == null) {
//			entity = new Funcionario();
//			entity.setEstado(new Estado());
//		}
//		
//		return entity;
//	}
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Funcionario> getListaFuncionario() {
		if (listaFuncionario == null)
			listaFuncionario = new ArrayList<Funcionario>();
		return listaFuncionario;
	}

	@Override
	public Funcionario getEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
