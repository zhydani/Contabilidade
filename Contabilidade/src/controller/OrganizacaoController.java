package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import application.Util;
import controller.listing.OrganizacaoListing;
import model.Organizacao;
import model.TipoEsfera;
import model.TipoPoder;

@Named
@ViewScoped
public class OrganizacaoController extends Controller<Organizacao> {

	private static final long serialVersionUID = 2453212862578738062L;
	
	

	@Override
	public Organizacao getEntity() {
		if (entity == null) {
			entity = new Organizacao();

		}
		return entity;
	}

	public void abrirOrganizacaoListing() {
		OrganizacaoListing listing = new OrganizacaoListing();
		listing.open();
	}
	
	public void obterOrganizacaoListing(SelectEvent event) {
        Organizacao entity = (Organizacao) event.getObject();
        setEntity(entity);
    }
	
	public TipoEsfera[] getListaTipoEsfera() {
		return TipoEsfera.values();
	}
	
	public TipoPoder[] getListaTipoPoder() {
		return TipoPoder.values();
	}

	public void abrirRelatorioOrganizacaoes() {
		Util.redirect("/faces/contadoresReport");
	}

}
