package controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.AlunoListing;
import model.Aluno;
import model.Cidade;
import model.Estado;
import model.Telefone;
import repository.CidadeRepository;
import repository.EstadoRepository;

@Named
@ViewScoped
public class AlunoController extends Controller<Aluno> {

	private static final long serialVersionUID = 5133323995601528105L;
	
	private String filtro;
	private List<Estado> listaEstado;
	private List<Cidade> listaCidade;
	
	@Override
	public void salvar() {
		
		if (getEntity().getCidade() != null && getEntity().getCidade().getId() == null)
			getEntity().setCidade(null);
		
		super.salvar();
	}
	
	public void abrirAlunoListing() {
		AlunoListing listing = new AlunoListing();
		listing.open();
	}
	
	public void obterAlunoListing(SelectEvent event) {
        Aluno entity = (Aluno) event.getObject();
        setEntity(entity);
    	if (getEntity().getCidade() == null) {
			getEntity().setCidade(new Cidade());
    		getEntity().getCidade().setEstado(new Estado());
    	}
    }
	
	@Override
	public Aluno getEntity() {
		if (entity == null) {
			entity = new Aluno();
			entity.setCidade(new Cidade());
			entity.getCidade().setEstado(new Estado());
			entity.setTelefone(new Telefone());
		}
		return entity;
	}
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Estado> getListaEstado() {
		if (listaEstado == null) {
			EstadoRepository repo = new EstadoRepository();
			listaEstado = repo.findByNome("");
		}
		return listaEstado;
	}

	public void setListaEstado(List<Estado> listaEstado) {
		this.listaEstado = listaEstado;
	}
	
	public void atualizarCidades() {
		listaCidade = null;
	}

	public List<Cidade> getListaCidade() {
		if (listaCidade == null) {
			CidadeRepository repo = new CidadeRepository();
			listaCidade = repo.findByNome("", getEntity().getCidade().getEstado().getId());
		}
		return listaCidade;
	}

	public void setListaCidade(List<Cidade> listaCidade) {
		this.listaCidade = listaCidade;
	}
	
}
