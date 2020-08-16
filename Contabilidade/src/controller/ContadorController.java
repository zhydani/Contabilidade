package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import application.Util;
import controller.listing.ContadorListing;
import controller.listing.ContadorListingSql;
import model.Contador;
import model.TipoUsuario;
import repository.ContadorRepository;

@Named
@ViewScoped
public class ContadorController extends Controller<Contador> {

	private static final long serialVersionUID = 2453212862578738062L;
	private String filtro;
	private List<Contador> listaContador;
	private InputStream fotoInputStream = null;
	private String nomeFoto = null;

	
	public String getNomeFoto() {
		if (nomeFoto == null)
			return "Selecione uma foto ...";
		return "Arquivo: " + nomeFoto + " (Clique para alterar a foto...)";
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
			// salvar a foto do contador
			if (Util.saveImageContador(fotoInputStream, "png", getEntity().getId())) {
				limpar();
				Util.addMessageInfo("Cadastro realizado com sucesso");
				return;
			} else {
				limpar();
				Util.addMessageWarn("O Cadastro foi realizado com sucesso, porem a foto nao foi salva.");
				return;
			}
		}
		Util.addMessageError("Erro ao efetuar o cadastro do contador.");
	}

	public void pesquisar() {
		ContadorRepository repo = new ContadorRepository();
		listaContador = repo.findByNome(getFiltro());
	}

	public void abrirContadorListing() {
		ContadorListingSql listing = new ContadorListingSql();
		listing.open();
	}

	public void obterContadorListing(SelectEvent event) {
		Contador entity = (Contador) event.getObject();
		setEntity(entity);
	}

	@Override
	public Contador getEntity() {
		if (entity == null) {
			entity = new Contador();

		}
		return entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Contador> getListaContador() {
		if (listaContador == null)
			listaContador = new ArrayList<Contador>();
		return listaContador;
	}

	public TipoUsuario[] getListaTipoUsuario() {
		return TipoUsuario.values();
	}

	public void abrirRelatorioContadores() {
		Util.redirect("/faces/contadoresReport");
	}

}
