package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

import controller.listing.FuncionarioListing;
import controller.listing.EmpresaListing;
import controller.listing.EstadoCivilListing;
import model.Funcionario;
import model.Empresa;
import model.EstadoCivil;
import repository.FuncionarioRepository;

@Named
@ViewScoped
public class FuncionarioController extends Controller<Funcionario> {

	private static final long serialVersionUID = 5133323995601528105L;
	
	private String filtro;
	private List<Funcionario> listaFuncionario;
	
	public void pesquisar() {
		FuncionarioRepository repo = new FuncionarioRepository();
		listaFuncionario = repo.findByNome(getFiltro());
	}
	
//	FUNCIONARIO
	public void abrirFuncionarioListing() {
		FuncionarioListing listing = new FuncionarioListing();
		listing.open();
	}
	
	public void obterFuncionarioListing(SelectEvent event) {
        Funcionario entity = (Funcionario) event.getObject();
        setEntity(entity);
    	if (getEntity().getEstadocivil() == null)
			getEntity().setEstadocivil(new EstadoCivil());
    	if (getEntity().getEmpresa() == null)
			getEntity().setEmpresa(new Empresa());
    }
	
//	ESTADO CIVIL
	public void abrirEstadoCivilListing() {
		EstadoCivilListing listing = new EstadoCivilListing();
		listing.open();
	}
	
	public void obterEstadoCivilListing(SelectEvent event) {
        EstadoCivil entity = (EstadoCivil) event.getObject();
        getEntity().setEstadocivil(entity);
    }
	
//	EMPRESA
	public void abrirEmpresaListing() {
		EmpresaListing listing = new EmpresaListing();
		listing.open();
	}
	
	public void obterEmpresaListing(SelectEvent event) {
        Empresa entity = (Empresa) event.getObject();
        getEntity().setEmpresa(entity);
    }
	
	@Override
	public Funcionario getEntity() {
		if (entity == null) {
			entity = new Funcionario();
			entity.setEstadocivil(new EstadoCivil());
			entity.setEmpresa(new Empresa());
		}
		
		return entity;
	}
	
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

	
}
