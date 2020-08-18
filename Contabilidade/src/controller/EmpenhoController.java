package controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.ClassificacaoOrcamentariaListing;
import controller.listing.EmpenhoListing;
import controller.listing.FornecedorCredorListing;
import controller.listing.OrganizacaoListing;
//import controller.listing.EmpenhoListing;
import model.Empenho;
import model.FornecedorCredor;
import model.Organizacao;
import model.ClassificacaoOrcamentaria;
import repository.ClassificacaoOrcamentariaRepository;
import repository.OrganizacaoRepository;
import repository.FornecedorCredorRepository;

@Named
@ViewScoped
public class EmpenhoController extends Controller<Empenho> {

	private static final long serialVersionUID = 5133323995601528105L;
	
	private String filtro;
	private List<ClassificacaoOrcamentaria> listaClassificacaoOrcamentaria;
	private List<Organizacao> listaOrganizacao;
	private List<FornecedorCredor> listaFornecedorCredor;
	
//	@Override
//	public void salvar() {
//		
//		if (getEntity().getOrganizacao() != null && getEntity().getOrganizacao().getId() == null)
//			getEntity().setOrganizacao(null);
//		if (getEntity().getClassificacaoOrcamentaria() != null && getEntity().getClassificacaoOrcamentaria().getId() == null)
//			getEntity().setClassificacaoOrcamentaria(null);
//		if (getEntity().getFornecedorCredor() != null && getEntity().getFornecedorCredor().getId() == null)
//			getEntity().setFornecedorCredor(null);
//		
//		super.salvar();
//	}
	
	public void abrirEmpenhoListing() {
		EmpenhoListing listing = new EmpenhoListing();
		listing.open();
	}
	
	public void obterEmpenhoListing(SelectEvent event) {
        Empenho entity = (Empenho) event.getObject();
        setEntity(entity);
    	if (getEntity().getOrganizacao() == null) {
			getEntity().setOrganizacao(new Organizacao());
    		
    	}
    	if (getEntity().getClassificacaoOrcamentaria() == null) {
			getEntity().setClassificacaoOrcamentaria(new ClassificacaoOrcamentaria());
    		
    	}
    	if (getEntity().getFornecedorCredor() == null) {
			getEntity().setFornecedorCredor(new FornecedorCredor());
    		
    	}
    }
	
	@Override
	public Empenho getEntity() {
		if (entity == null) {
			entity = new Empenho();
			entity.setOrganizacao(new Organizacao());
			entity.setClassificacaoOrcamentaria(new ClassificacaoOrcamentaria());
			entity.setFornecedorCredor(new FornecedorCredor());
		}
		return entity;
	}
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
//	public void atualizarOrganizacoes() {
//		listaOrganizacao = null;
//	}
//	public void atualizarClassificacoes() {
//		listaClassificacaoOrcamentaria = null;
//	}
//	public void atualizarFornecedores() {
//		listaFornecedorCredor = null;
//	}

	public List<Organizacao> getListaOrganizacao() {
		if (listaOrganizacao == null) {
			OrganizacaoRepository repo = new OrganizacaoRepository();
			listaOrganizacao = repo.findByNome("");
		}
		return listaOrganizacao;
	}

	public void setListaCidade(List<Organizacao> listaOrganizacao) {
		this.listaOrganizacao = listaOrganizacao;
	}
	
	
	public List<FornecedorCredor> getListaFornecedorCredor() {
		if (listaFornecedorCredor == null) {
			FornecedorCredorRepository repo = new FornecedorCredorRepository();
			listaFornecedorCredor = repo.findByNome("");
		}
		return listaFornecedorCredor;
	}

	public void setListaFornecedorCredor(List<FornecedorCredor> listaFornecedorCredor) {
		this.listaFornecedorCredor = listaFornecedorCredor;
	}
	
	public List<ClassificacaoOrcamentaria> getListaClassificacaoOrcamentaria() {
		if (listaClassificacaoOrcamentaria == null) {
			ClassificacaoOrcamentariaRepository repo = new ClassificacaoOrcamentariaRepository();
			listaClassificacaoOrcamentaria = repo.findByNumero("");
		}
		return listaClassificacaoOrcamentaria;
	}

	public void setListaClassificacaoOrcamentaria(List<ClassificacaoOrcamentaria> listaClassificacaoOrcamentaria) {
		this.listaClassificacaoOrcamentaria = listaClassificacaoOrcamentaria;
	}
	
	public void abrirOrganizacaoListing() {
		OrganizacaoListing listing = new OrganizacaoListing();
		listing.open();
	}

	public void obterOrganizacaoListing(SelectEvent event) {
		Organizacao entity = (Organizacao) event.getObject();
		getEntity().setOrganizacao(entity);
	}
	
	public void abrirClassificacaoOrcamentariaListing() {
		ClassificacaoOrcamentariaListing listing = new ClassificacaoOrcamentariaListing();
		listing.open();
	}

	public void obterClassificacaoOrcamentariaListing(SelectEvent event) {
		ClassificacaoOrcamentaria entity = (ClassificacaoOrcamentaria) event.getObject();
		getEntity().setClassificacaoOrcamentaria(entity);
	}
	
	public void abrirFornecedorCredorListing() {
		FornecedorCredorListing listing = new FornecedorCredorListing();
		listing.open();
	}

	public void obterFornecedorCredorListing(SelectEvent event) {
		FornecedorCredor entity = (FornecedorCredor) event.getObject();
		getEntity().setFornecedorCredor(entity);
	}
}
