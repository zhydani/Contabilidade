package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.file.UploadedFile;

import application.Util;
import controller.listing.CidadeListing;
import controller.listing.EstadoListing;
import controller.listing.ProfessorListing;
import controller.listing.ProfessorListingSql;
import model.Cidade;
import model.Estado;
import model.Professor;
import model.TipoUsuario;
import repository.ProfessorRepository;

@Named
@ViewScoped
public class ProfessorController extends Controller<Professor> {

	private static final long serialVersionUID = 2453212862578738062L;
	private String filtro;
	private List<Professor> listaProfessor;
	private Estado estado;
	private InputStream fotoInputStream = null;
	private String nomeFoto = null;
	
	public void upload(FileUploadEvent event) {
		
		UploadedFile uploadFile =  event.getFile();
		System.out.println("nome arquivo: "+ uploadFile.getFileName());
		System.out.println("tipo: "+ uploadFile.getContentType());
		System.out.println("tamanho: "+ uploadFile.getSize());
		
		if (uploadFile.getContentType().equals("image/png")) {
			try {
				fotoInputStream = uploadFile.getInputStream();
				nomeFoto = uploadFile.getFileName();
				System.out.println("inputStream: "+ uploadFile.getInputStream().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Util.addMessageInfo("Upload realizado com sucesso.");
		} else {
			Util.addMessageError("O tipo da image deve ser png.");
		}
        
    }
	
	public String getNomeFoto() {
		if (nomeFoto == null) 
			return "Selecione uma foto ...";
		return "Arquivo: "+ nomeFoto + " (Clique para alterar a foto...)";
	}
	
	
	@Override
	public void limpar() {
		// TODO Auto-generated method stub
		super.limpar();
		fotoInputStream = null;
		nomeFoto = null;
	}
	
	@Override
	public void salvar() {
		// salvando no banco de dados
		if (salvarEspecial()) {
			// caso nao tenha selecionado a imagem sair do metodo
			if (fotoInputStream == null) {
				limpar();
				Util.addMessageInfo("Cadastro realizado com sucesso");
				return;
			}
			// salvar a foto do professor
			if (Util.saveImageProfessor(fotoInputStream, "png", getEntity().getId())) {
				limpar();
				Util.addMessageInfo("Cadastro realizado com sucesso");
				return;
			} else {
				limpar();
				Util.addMessageWarn("O Cadastro foi realizado com sucesso, porem a foto nao foi salva.");
				return;
			}
		}
		Util.addMessageError("Erro ao efetuar o cadastro do professor.");
	}
	
	public void pesquisar() {
		ProfessorRepository repo = new ProfessorRepository();
		listaProfessor = repo.findByNome(getFiltro());
	}
	
	public void abrirProfessorListing() {
		ProfessorListingSql listing = new ProfessorListingSql();
		listing.open();
	}
	
	public void obterProfessorListing(SelectEvent event) {
        Professor entity = (Professor) event.getObject();
        setEntity(entity);
    }
	
	
	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();
	}
	
	public void obterEstadoListing(SelectEvent event) {
        Estado entity = (Estado) event.getObject();
        if (!entity.getId().equals(getEntity().getCidade().getEstado().getId())) {
        	getEntity().setCidade(new Cidade());
        	getEntity().getCidade().setEstado(entity);
		}
    }
	
	public void abrirCidadeListing() {
		CidadeListing listing = new CidadeListing();
		listing.open(getEntity().getCidade().getEstado().getId());
	}
	
	public void obterCidadeListing(SelectEvent event) {
        Cidade entity = (Cidade) event.getObject();
        getEntity().setCidade(entity);
    }	
	
	@Override
	public Professor getEntity() {
		if (entity == null) {
			entity = new Professor();
			entity.setCidade(new Cidade());
			entity.getCidade().setEstado(new Estado());
		}
		return entity;
	}
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Professor> getListaProfessor() {
		if (listaProfessor == null)
			listaProfessor = new ArrayList<Professor>();
		return listaProfessor;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public TipoUsuario[] getListaTipoUsuario() {
		return TipoUsuario.values();
	}
	
	
	public void abrirRelatorioProfessores() {
		Util.redirect("/faces/professoresReport");
	}
	
	
}
