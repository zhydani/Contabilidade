package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.ClassificacaoOrcamentariaListing;
import model.ClassificacaoOrcamentaria;

@Named
@ViewScoped
public class ClassificacaoOrcamentariaController extends Controller<ClassificacaoOrcamentaria> {

	private static final long serialVersionUID = 8881610383057468107L;

	@Override
	public ClassificacaoOrcamentaria getEntity() {
		if (entity == null) {
			entity = new ClassificacaoOrcamentaria();
		}
		return entity;
	}
	
	public void abrirClassificacaoOrcamentariaListing() {
		ClassificacaoOrcamentariaListing listing = new ClassificacaoOrcamentariaListing();
		listing.open();
	}
	
	public void obterClassificacaoOrcamentariaListing(SelectEvent event) {
        ClassificacaoOrcamentaria entity = (ClassificacaoOrcamentaria) event.getObject();
        setEntity(entity);
    }

}
